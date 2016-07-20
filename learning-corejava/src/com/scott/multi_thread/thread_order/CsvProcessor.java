package com.scott.multi_thread.thread_order;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Ying
 *  
 * Since I am not sure the performance of 8 core, the following program is set up to be adjustable. 
 * this program can configure how many threads run at the same time, 
 * and how many records could be processed by one thread.
 * 
 * I propose to use ExecutorService to manage threads, and to use Semaphore to control 
 * the amount of threads running at the same time. 
 * 
 * I didn't load the whole file to memory, but use FileInputStream and Scanner to load
 * records one by one.
 * 
 * CSV_PATH: the path of CSV file. 
 * MAX_THREADS_NUMBER: how many threads run at the same time. 
 * RECORD_NUMBER_OF_THREAD: how many records could be processed by one thread.
 * 
 * Example of CSV file:
 * field_1/1,field_1/2,field_1/3,field_1/4,field_1/5,field_1/6,field_1/7,field_1/8,field_1/9,field_1/10
 * field_2/1,field_2/2,field_2/3,field_2/4,field_2/5,field_2/6,field_2/7,field_2/8,field_2/9,field_2/10
 * field_3/1,field_3/2,field_3/3,field_3/4,field_3/5,field_3/6,field_3/7,field_3/8,field_3/9,field_3/10
 * 
 * How to use:
 * This class already has main method, so just need to replace CSV_PATH to your own CSV file path, 
 * and then run this class.
 * 
 */
public class CsvProcessor {

	private static final String CSV_PATH = "F:\\testcsv.csv";

	private static final int MAX_THREADS_NUMBER = 9;
	private static final int RECORD_NUMBER_OF_THREAD = 4;

	private ExecutorService executorService = Executors.newCachedThreadPool();
	private Semaphore semaphore = new Semaphore(MAX_THREADS_NUMBER);

	/**
	 * @author Ying
	 *
	 * I use Runnable here because we don't need to return. If it needs to return, 
	 * we can use Callable, Future, and CompletionService instead of Runnable.
	 */
	private class ProcessorThread implements Runnable {
		private List<Record> records;
		private Semaphore semaphore;

		public ProcessorThread(List<Record> records, Semaphore semaphore) {
			this.records = records;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				for (Record record : records) {
					TimeUnit.SECONDS.sleep(new Random().nextInt(8) + 3); //sleep 3 to 10 seconds.
					System.out.println(Thread.currentThread().getName() + "   " + record);
				}
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void processCsv(String path) throws IOException {
		FileInputStream inputStream = null;
		Scanner scanner = null;

		List<Record> tempRecords = new ArrayList<Record>();

		try {
			inputStream = new FileInputStream(path);
			scanner = new Scanner(inputStream, "UTF-8");
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				tempRecords.add(new Record(line.split(",")));

				if (tempRecords.size() >= RECORD_NUMBER_OF_THREAD) {
					executorService.submit(new ProcessorThread(tempRecords, semaphore));
					tempRecords = new ArrayList<Record>();
				}
			}

			if (tempRecords.size() > 0)
				executorService.submit(new ProcessorThread(tempRecords, semaphore));

			if (scanner.ioException() != null) {
				throw scanner.ioException();
			}
		} finally {
			if (inputStream != null)
				inputStream.close();
			if (scanner != null)
				scanner.close();
			if (executorService != null)
				executorService.shutdown();
		}
	}

	public static void main(String[] args) {
		try {
			new CsvProcessor().processCsv(CSV_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 
 * @author Ying
 * 
 * The model of record in CSV file.
 *
 */
class Record {

	private String field1;
	private String field2;
	private String field3;
	private String field4;
	private String field5;
	private String field6;
	private String field7;
	private String field8;
	private String field9;
	private String field10;

	public Record() {
	}

	public Record(String[] fields) {
		this.field1 = fields[0];
		this.field2 = fields[1];
		this.field3 = fields[2];
		this.field4 = fields[3];
		this.field5 = fields[4];
		this.field6 = fields[5];
		this.field7 = fields[6];
		this.field8 = fields[7];
		this.field9 = fields[8];
		this.field10 = fields[9];
	}

	@Override
	public String toString() {
		return "Field 1:" + getField1() + ", Field 2:" + getField2() + ", Field 3:" + getField3() + ", Field 4:" + getField4() + ", Field 5:" + getField5() + ", Field 6:" + getField6() + ", Field 7:" + getField7() + ", Field 8:" + getField8() + ", Field 9:" + getField9() + ", Field 10:" + getField10();
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public String getField6() {
		return field6;
	}

	public void setField6(String field6) {
		this.field6 = field6;
	}

	public String getField7() {
		return field7;
	}

	public void setField7(String field7) {
		this.field7 = field7;
	}

	public String getField8() {
		return field8;
	}

	public void setField8(String field8) {
		this.field8 = field8;
	}

	public String getField9() {
		return field9;
	}

	public void setField9(String field9) {
		this.field9 = field9;
	}

	public String getField10() {
		return field10;
	}

	public void setField10(String field10) {
		this.field10 = field10;
	}

}
