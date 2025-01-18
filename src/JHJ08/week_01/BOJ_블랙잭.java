package src.JHJ08.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_블랙잭 {

	static int [] arrCard;
	static boolean [] visit;

	static int res = -9999;
	static int nNumber;

	static void dfs(int start, int count, int sum)
	{
		if(count == 3)
		{
			if (sum <= nNumber && sum > res)
			{
				res = sum;
			}

			return;
		}

		for(int i=start; i<arrCard.length; i++)
		{
			if(visit[i] == false)
			{
				visit[i]=true;
				dfs(i+1,count+1, sum+arrCard[i]);
				visit[i]=false;
			}
		}
	}

	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		int nCount = Integer.parseInt(st.nextToken()); // 카드 개수
		nNumber = Integer.parseInt(st.nextToken()); // 합

		arrCard = new int[nCount];
		visit = new boolean[nCount];
		st = new StringTokenizer(br.readLine());

		for(int i=0; i<nCount; i++)
		{
			arrCard[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0,0,0);

		System.out.println(res);

	}
}
