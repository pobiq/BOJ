import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class Main {
	
	static class Tree {
		int value;
		Tree left;
		Tree right;
		
		public Tree(int value) {
			this.value = value;
		}
		
		void insert(int value) {
			if(value < this.value) {
				if(this.left == null) {
					this.left = new Tree(value);
				} else {
					this.left.insert(value);
				}
			} else {
				if(this.right == null) {
					this.right = new Tree(value);
				} else {
					this.right.insert(value);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		Tree tree = new Tree(Integer.parseInt(br.readLine()));
		
		String input;
		
		while((input = br.readLine()) != null) {
			tree.insert(Integer.parseInt(input));
		}
		
		postOrder(tree);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void postOrder(Tree tree) {
		if(tree == null) return;
		postOrder(tree.left);
		postOrder(tree.right);
		System.out.println(tree.value);
	}
	
}