package com.index;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import java.nio.file.Paths;

/**
 * 根据某一个Field的特殊值进行查询加权
 *
 * @author yaomianxian
 * @date 2024/03/28 0028 16:05
 */
public class IndexingTest2 {

    private static Directory dir; //存放索引的位置

    //准备一下数据，四个人写了四篇文章，Json是boss
    private static String ids[]={"1","2","3","4"};
    private static String authors[]={"Jack","Marry","John","Json"};
    private static String positions[]={"accounting","technician","salesperson","boss"};
    private static String titles[]={"Java is a good language.","Java is a cross platform language","Java powerful","You should learn java"};
    private static String contents[]={
            "If possible, use the same JRE major version at both index and search time.",
            "When upgrading to a different JRE major version, consider re-indexing. ",
            "Different JRE major versions may implement different versions of Unicode.",
            "For example: with Java 1.4, `LetterTokenizer` will split around the character U+02C6."
    };

    public static void index() throws Exception { //生成索引
        dir = FSDirectory.open(Paths.get("D:\\index"));
        IndexWriter writer = getWriter();
        for(int i = 0; i < ids.length; i++) {
            Document doc = new Document();
            doc.add(new StringField("id", ids[i], Field.Store.YES));
            doc.add(new StringField("author", authors[i], Field.Store.YES));
            doc.add(new StringField("position", positions[i], Field.Store.YES));
//            doc.add(new StringField("title", titles[i], Field.Store.YES));

//            //这部分就是加权操作了，对title这个Field进行加权，因为等会我要查这个Field
            TextField field = new TextField("title", titles[i], Field.Store.YES);
//            //先判断之个人对应的职位是不是boss，如果是就加权
            doc.add(field);


            doc.add(new TextField("content", contents[i], Field.Store.NO));
            writer.addDocument(doc); //添加文档
        }
        writer.close(); //close了才真正写到文档中
    }

    //获取IndexWriter实例
    private static IndexWriter getWriter() throws Exception {
        Analyzer analyzer = new StandardAnalyzer(); //标准分词器，会自动去掉空格啊，is a the等单词
        IndexWriterConfig config = new IndexWriterConfig(analyzer); //将标准分词器配到写索引的配置中
        IndexWriter writer = new IndexWriter(dir, config); //实例化写索引对象
        return writer;
    }

    public static void main(String[] args) throws Exception {
        index();

        dir = FSDirectory.open(Paths.get("D:\\index"));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher search = new IndexSearcher(reader);
        String searchField = "title"; //要查询的Field
        String q = "java"; //要查询的字符串
        Term term = new Term(searchField, q);
        Query query = new TermQuery(term);
        // 未加权的情况
//        TopDocs hits = search.search(query, 10);
//        System.out.println("匹配" + q + "总共查询到" + hits.totalHits + "个文档");
//        for(ScoreDoc score : hits.scoreDocs) {
//            Document doc = search.doc(score.doc);
//            System.out.println(doc.get("author")); //打印一下查出来记录对应的作者
//        }

        // 构建职位为 boss 的查询
        TermQuery bossQuery = new TermQuery(new Term("position", "technician"));
        // 对职位为 boss 的查询结果进行加权操作
        BoostQuery boostBossQuery = new BoostQuery(bossQuery, 1.5f);

        // 构建布尔查询，将普通查询和职位为 boss 的加权查询组合在一起
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        booleanQuery.add(query, BooleanClause.Occur.SHOULD); // 普通查询
        booleanQuery.add(boostBossQuery, BooleanClause.Occur.SHOULD); // 职位为 boss 的加权查询

        TopDocs hits = search.search(booleanQuery.build(), 10);
        System.out.println("匹配" + q + "总共查询到" + hits.totalHits + "个文档");
        for(ScoreDoc score : hits.scoreDocs) {
            Document doc = search.doc(score.doc);
            System.out.println(doc.get("author")); //打印一下查出来记录对应的作者
        }

        reader.close();
    }



}
