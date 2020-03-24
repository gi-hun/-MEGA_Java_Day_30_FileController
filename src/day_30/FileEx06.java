package day_30;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileEx06 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] vector = null;
		int count = 0;
		
		String fileName = "vector.txt";
		
		while(true) {
			for(int i=0;i<count;i++)
			{
				System.out.print(vector[i] + " ");
			}
			System.out.println();
			
			System.out.println("[���� ��Ʈ�ѷ�]");
			System.out.println("[1]�߰��ϱ�");
			System.out.println("[2]�����ϱ�");
			System.out.println("[3]�����ϱ�");
			System.out.println("[4]�ε��ϱ�");
			System.out.println("[5]�����ϱ�");
			
			System.out.print("�޴� ���� : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {		//�߰��ϱ�
				if(count == 0)
				{
					vector = new int[count+1];
				}
				else if(count>0)
				{
					int[] temp = vector;
					vector = new int[count+1];
					
					for(int i=0;i<count;i++)
					{
						vector[i] = temp[i];
					}
				}
				System.out.println("[�߰�]������ �Է�:");
				int data = sc.nextInt();
				
				vector[count] = data;
				count++;
			}
			else if(sel == 2) {		//�����ϱ�
				System.out.println("[����]�ε��� �Է�");
				int delIdx = sc.nextInt();
				
				//count-1<delIdx -> ������ �ε����� �迭 �ε��� ���� �Ѿ��
				//delIdx<0 -> ������ �ε����� 0���� ������
				if(count-1<delIdx || delIdx<0)
				{
					System.out.println("[�޼���]�ش� ��ġ�� ������ �� �����ϴ�.");
					continue;
				}
				
				if(count == 1)
				{
					vector=null;
				}
				else if(count>1)
				{
					int[] temp = vector;
					vector = new int[count-1];
					
					int j=0;
					for(int i=0;i<count;i++)
					{
						if(i != delIdx)
						{
							vector[j] = temp[i];
							j++;
						}
					}
				}
				count--;
			}
			else if(sel == 3) {		//�����ϱ�
				String data = "";
				if(count>0)
				{
					for(int i=0;i<count;i++)
					{
						data += vector[i];
						data += "\n";
					}
					data = data.substring(0, data.length()-1);
					
					FileWriter fw = null;
					try
					{
						fw = new FileWriter(fileName);
						fw.write(data);
						fw.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("[�޼���] ������ �����Ͱ� �����ϴ�.");
				}
				
			}
			else if(sel == 4) {		//�ε��ϱ�
				String data = "";
				File file = new File(fileName);
				if(file.exists())
				{
					FileReader fr = null;
					BufferedReader br = null;
					try
					{
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						while(true)
						{
							String line = br.readLine();
							if(line == null)
							{
								break;
							}
							
							data += line;
							data += "\n";
						}
						data = data.substring(0, data.length()-1);
						
						String[] temp = data.split("\n");
						count = temp.length;
						
						vector = new int[count];
						
						for(int i=0;i<count; i++)
						{
							vector[i] = Integer.parseInt(temp[i]);
						}
						fr.close();
						br.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
			else if(sel == 5) {
				System.out.println("���α׷� ����");
				break;
			}
			
		}

	}
}
