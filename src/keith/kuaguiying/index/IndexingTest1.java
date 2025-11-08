package com.index;

import org.apache.lucene.index.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Paths;

/**
 * 建立索引、修改索引，删除索引
 *
 * @author yaomianxian
 * @date 2024/03/28 0028 14:02
 */
public class IndexingTest1 {

    private static Directory dir;

    private static String ids[] = {"1", "2", "3"}; //用来标识文档
    private static String citys[] = {"shanghai", "nanjing", "qingdao"};
    private static String descs[] = {
            "Shanghai is a bustling city.",
            "Nanjing is a city of culture.",
            "Qingdao is a beautiful city"
    };

    //生成索引
    public static void index() throws Exception {
        IndexWriter writer = getWriter(); //获取写索引的实例
        for (int i = 0; i < ids.length; i++) {
            Document doc = new Document();
            doc.add(new StringField("id", ids[i], Field.Store.YES));
            doc.add(new StringField("city", citys[i], Field.Store.YES));
            doc.add(new TextField("descs", descs[i], Field.Store.NO));
            writer.addDocument(doc); //添加文档
        }
        writer.close(); //close了才真正写到文档中
    }

    //获取IndexWriter实例
    private static IndexWriter getWriter() throws Exception {
        dir = FSDirectory.open(Paths.get("D:\\index\\"));
        Analyzer analyzer = new StandardAnalyzer(); //标准分词器，会自动去掉空格啊，is a the等单词
        IndexWriterConfig config = new IndexWriterConfig(analyzer); //将标准分词器配到写索引的配置中
        IndexWriter writer = new IndexWriter(dir, config); //实例化写索引对象
        return writer;
    }



    public static void main(String[] args) throws Exception {
        index();
//
//        IndexWriter writer = getWriter();
//        System.out.println("总共写入了" + writer.numDocs() + "个文档");
//        writer.close();
//
//        dir = FSDirectory.open(Paths.get("D:\\index\\"));
//        IndexReader reader = DirectoryReader.open(dir);
//        System.out.println("最大文档数：" + reader.maxDoc());
//        System.out.println("实际文档数：" + reader.numDocs());
//        reader.close();

//        IndexWriter writer = getWriter();
//        System.out.println("删除前有" + writer.numDocs() + "个文档");
//        writer.deleteDocuments(new Term("id", "1")); //删除id=1对应的文档
//        writer.commit(); //提交删除,并没有真正删除
//        System.out.println("删除后最大文档数：" + writer.maxDoc());
//        System.out.println("删除后实际文档数：" + writer.numDocs());
//        writer.close();

//        IndexWriter writer = getWriter();
//        System.out.println("删除前有" + writer.numDocs() + "个文档");
//        writer.deleteDocuments(new Term("id", "1")); //删除id=1对应的文档
//        writer.forceMergeDeletes(); //强制合并（强制删除），没有索引了
//        writer.commit(); //提交删除，真的删除了
//        System.out.println("删除后最大文档数：" + writer.maxDoc());
//        System.out.println("删除后实际文档数：" + writer.numDocs());
//        writer.close();

        IndexWriter writer = getWriter();
        //新建一个Document
        Document doc = new Document();
        doc.add(new StringField("id", ids[1], Field.Store.YES));
        doc.add(new StringField("city", "shanghai22", Field.Store.YES));
        doc.add(new TextField("descs", "shanghai update", Field.Store.NO));

        //将原来id为1对应的文档，用新建的文档替换
        writer.updateDocument(new Term("id", "1"), doc);
        writer.close();
        System.out.println(doc.getField("descs"));
    }

}
