package com.techthinker.CAWeb.analyzer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefualtConfig;
import org.wltea.analyzer.dic.Dictionary;

import com.techthinker.CAWeb.idao.IUserDao;
import com.techthinker.CAWeb.util.SystemConstant;
import com.techthinker.CAWeb.vo.User;

@Service("etartService")
public class EtartAnalyzer {
	private IUserDao userDao;
	private Configuration defualtConfig = DefualtConfig.getInstance();

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void updateUsernameDic(String username) {
		Dictionary dic = Dictionary.initial(defualtConfig);
		List<String> extDics = defualtConfig.getExtDictionarys();
		String extPath = null;
		BufferedWriter writer = null;
		for (String ext : extDics) {
			if (ext.contains("username"))
				extPath = SystemConstant.CLASSPATH + ext;
		}
		System.out
				.println("---------------------22222222222222222---------------"
						+ SystemConstant.CLASSPATH
						+ "-----------------------------------------------------------");
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(extPath, true), "UTF-8"));
			List<String> usernames = new ArrayList<String>();
			usernames.add(username);
			dic.addWords(usernames);
			writer.write(username);
			writer.newLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateUserDic(List<User> users) {
		Dictionary dic = Dictionary.initial(defualtConfig);
		List<String> extDics = defualtConfig.getExtDictionarys();
		String extPath = null;
		BufferedWriter writer = null;
		for (String ext : extDics) {
			if (ext.contains("username"))
				extPath = SystemConstant.CLASSPATH + ext;
		}
		System.out
		.println("---------------------22222222222222222---------------"
				+ SystemConstant.CLASSPATH
				+ "-----------------------------------------------------------");
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(extPath, true), "UTF-8"));
			List<String> usernames = new ArrayList<String>();
			for (User u : users) {
				usernames.add(u.getUsername());
				writer.write(u.getUsername());
				writer.newLine();
			}
			dic.addWords(usernames);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// public void demo() {
	//
	// // Lucene Document的域名
	// String fieldName = "text";
	// // 检索内容
	// String text = "IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。";
	//
	// // 实例化IKAnalyzer分词器
	// Analyzer analyzer = new IKAnalyzer();
	//
	// Directory directory = null;
	// IndexWriter iwriter = null;
	// IndexReader ireader = null;
	// IndexSearcher isearcher = null;
	// try {
	// // 建立内存索引对象
	// directory = new RAMDirectory();
	//
	// // 配置IndexWriterConfig
	// IndexWriterConfig iwConfig = new IndexWriterConfig(
	// Version.LUCENE_34, analyzer);
	// iwConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
	// iwriter = new IndexWriter(directory, iwConfig);
	// // 写入索引
	// Document doc = new Document();
	// doc.add(new Field("ID", "10000", Field.Store.YES,
	// Field.Index.NOT_ANALYZED));
	// doc.add(new Field(fieldName, text, Field.Store.YES,
	// Field.Index.ANALYZED));
	// iwriter.addDocument(doc);
	// iwriter.close();
	//
	// // 搜索过程**********************************
	// // 实例化搜索器
	// ireader = IndexReader.open(directory);
	// isearcher = new IndexSearcher(ireader);
	//
	// String keyword = "中文分词工具包";
	// // 使用QueryParser查询分析器构造Query对象
	// QueryParser qp = new QueryParser(Version.LUCENE_34, fieldName,
	// analyzer);
	// qp.setDefaultOperator(QueryParser.AND_OPERATOR);
	// Query query = qp.parse(keyword);
	//
	// // 搜索相似度最高的5条记录
	// TopDocs topDocs = isearcher.search(query, 5);
	// System.out.println("命中：" + topDocs.totalHits);
	// // 输出结果
	// ScoreDoc[] scoreDocs = topDocs.scoreDocs;
	// for (int i = 0; i < topDocs.totalHits; i++) {
	// Document targetDoc = isearcher.doc(scoreDocs[i].doc);
	// System.out.println("内容：" + targetDoc.toString());
	// }
	//
	// } catch (CorruptIndexException e) {
	// e.printStackTrace();
	// } catch (LockObtainFailedException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } catch (ParseException e) {
	// e.printStackTrace();
	// } finally {
	// if (ireader != null) {
	// try {
	// ireader.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// if (directory != null) {
	// try {
	// directory.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// }
}
