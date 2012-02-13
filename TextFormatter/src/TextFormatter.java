import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class TextFormatter {
	HashMap<String, ArrayList<ArrayList<String>>> hashMap = new HashMap<String, ArrayList<ArrayList<String>>>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextFormatter temp = new TextFormatter();
		temp.format();
	}

	public void format() {
		try {

			File file = new File("budget.txt");

			BufferedReader bufRdr = new BufferedReader(new FileReader(file));
			String line = null;

			// read each line of text file

			while ((line = bufRdr.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t");

				while (st.hasMoreTokens()) {

					String col_one = st.nextToken();
					while (st.hasMoreTokens()) {
						String col2 = st.nextToken();
						String col3 = st.nextToken();
						if (hashMap.containsKey(col_one)) {
							ArrayList<ArrayList<String>> al = hashMap
									.get(col_one);
							ArrayList<String> tempAL = new ArrayList<String>();
							tempAL.add(col2);
							tempAL.add(col3);
							al.add(tempAL);

							hashMap.put(col_one, al);

						} else {
							ArrayList<String> tempAL = new ArrayList<String>();
							tempAL.add(col2);
							tempAL.add(col3);
							ArrayList<ArrayList<String>> tempALContainer = new ArrayList<ArrayList<String>>();
							tempALContainer.add(tempAL);
							hashMap.put(col_one, tempALContainer);
						}

					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zoomedOut();
	}

	/** Simple Program to write a text file */
	public void zoomedOut() {
		try {
			FileWriter outFile = new FileWriter("zoomedOut.js");
			PrintWriter out = new PrintWriter(outFile);

			// Write text to file
			java.util.Iterator<String> iterator = hashMap.keySet().iterator();

			out.println("var flare = {");
			while (iterator.hasNext()) {
				String col_one = iterator.next();
				ArrayList<ArrayList<String>> al = hashMap.get(col_one);

				double cum = 0;
				for (int i = 0; i < al.size(); i++) {

					ArrayList<String> subfunc = al.get(i);
					cum = cum + Double.parseDouble(subfunc.get(1));

				}
				
				out.println("\"" + col_one + "\": " + String.format("%f", cum)
						+ ",");

			}
			out.println("};");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void WriteText() {
		try {
			FileWriter outFile = new FileWriter("outputFile.txt");
			PrintWriter out = new PrintWriter(outFile);

			// Write text to file
			java.util.Iterator<String> iterator = hashMap.keySet().iterator();

			out.println("var flare = {");
			while (iterator.hasNext()) {
				String col_one = iterator.next();
				ArrayList<ArrayList<String>> al = hashMap.get(col_one);

				out.println("\"" + col_one + "\": {");
				for (int i = 0; i < al.size(); i++) {
					ArrayList<String> subfunc = al.get(i);
					out.println("\t\"" + subfunc.get(0) + "\":"
							+ subfunc.get(1) + ",");
				}
				out.println("},");
			}
			out.println("};");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void WriteTextHighCharts() {
		try {
			FileWriter outFile = new FileWriter("file.js");
			PrintWriter out = new PrintWriter(outFile);

			// Write text to file
			java.util.Iterator<String> iterator = hashMap.keySet().iterator();

			out.println("var flare = [");
			while (iterator.hasNext()) {
				String col_one = iterator.next();
				ArrayList<ArrayList<String>> al = hashMap.get(col_one);

				double cum = 0;
				for (int i = 0; i < al.size(); i++) {

					ArrayList<String> subfunc = al.get(i);
					cum = cum + Double.parseDouble(subfunc.get(1));

				}

				out.println("{ name:" + "'" + col_one + "', y: "
						+ String.format("%f", cum) + ", color: '#4572A7'},");
			}
			out.println("];");

			// Write text to file
			iterator = hashMap.keySet().iterator();

			out.println("var flare2 = [");
			while (iterator.hasNext()) {
				String col_one = iterator.next();
				ArrayList<ArrayList<String>> al = hashMap.get(col_one);

				double cum = 0;
				for (int i = 0; i < al.size(); i++) {

					ArrayList<String> subfunc = al.get(i);
					// cum = cum + Double.parseDouble(subfunc.get(1));
					out.println("{ name:" + "'" + subfunc.get(0) + "', y: "
							+ subfunc.get(1) + "},");

				}

			}
			out.println("];");

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void WriteTextDonut() {
		try {
			FileWriter outFile = new FileWriter("donutfile.js");
			PrintWriter out = new PrintWriter(outFile);

			// Write text to file
			java.util.Iterator<String> iterator = hashMap.keySet().iterator();

			out.println("var flare = {");
			while (iterator.hasNext()) {
				String col_one = iterator.next();
				ArrayList<ArrayList<String>> al = hashMap.get(col_one);

				double cum = 0;
				for (int i = 0; i < al.size(); i++) {

					ArrayList<String> subfunc = al.get(i);
					cum = cum + Double.parseDouble(subfunc.get(1));

				}

				out.println("'" + col_one + "': " + String.format("%f", cum)
						+ ",");
			}
			out.println("};");

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}