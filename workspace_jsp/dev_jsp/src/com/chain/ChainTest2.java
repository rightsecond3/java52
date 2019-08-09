package com.chain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class ChainTest2 {
	public static ArrayList<Block> blockChain = new ArrayList<Block>();
	
	public static void main(String[] arags) {
		blockChain.add(new Block("2000", "0"));
		blockChain.add(new Block("3000", blockChain.get(blockChain.size()-1).hash));
		blockChain.add(new Block("5000", blockChain.get(blockChain.size()-1).hash));
		String jsonBlockChain = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
		System.out.println(jsonBlockChain);
	}

}
