package src.JHJ08.week_01;

import java.io.*;
import java.util.*;

public class BOJ_소가길을건너간이유1 {

	public static class info
	{
		public int cnt;
		public int lastPos;

		public info(int cnt, int lastPos)
		{
			this.cnt = cnt;
			this.lastPos = lastPos;
		}
	}

	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = Integer.parseInt(st.nextToken());

		Map<Integer, info> mapCowInfo = new HashMap<>();

		for(int i=0; i<num; i++)
		{
			st = new StringTokenizer(br.readLine());

			int number = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());


			if(mapCowInfo.containsKey(number))
			{
				info prevInfo = mapCowInfo.get(number);

				if(prevInfo.lastPos != pos)
				{
					mapCowInfo.put(number,new info(prevInfo.cnt+1, pos));
				}
			}
			else
			{
				mapCowInfo.put(number, new info(0, pos));
			}
		}

		int res = 0;

		for (Integer key : mapCowInfo.keySet()) {
			info curInfo = mapCowInfo.get(key);
			res+=curInfo.cnt;
		}

		System.out.println(res);

	}
}

