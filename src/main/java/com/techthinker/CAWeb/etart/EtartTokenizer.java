package com.techthinker.CAWeb.etart;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class EtartTokenizer {
	public static List<KeyWord> Analyze(String rawString) {
		StringReader sr = new StringReader(rawString);
		List<KeyWord> keyWords = new ArrayList<KeyWord>();
		IKSegmenter ikSegmenter = new IKSegmenter(sr,
				EtartDictionary.defualtConfig);
		Lexeme lexeme=null;
		String kw=null;
		try {
			while((lexeme=ikSegmenter.next())!=null){
				KeyWord keyWord=new KeyWord();
				kw=lexeme.getLexemeText();
				if(!kw.equals("")){
					keyWord.setKey(kw);
					keyWords.add(keyWord);
				}
			}
		} catch (IOException e) {
			System.out.println("关键词分词失败");
			e.printStackTrace();
		}
		return keyWords;
	}
}
