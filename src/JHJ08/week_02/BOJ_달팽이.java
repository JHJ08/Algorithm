package src.JHJ08.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_달팽이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine()); // 배열의 크기
		int number = Integer.parseInt(br.readLine()); // 찾고자 하는 숫자

		int [][] arr = new int [size][size];  // 배열 선언
		int currentNumber = size * size;      // 채울 숫자 (크기 * 크기)

		// 아래, 오른쪽, 위쪽, 왼쪽 방향 설정
		int [] dx = {1, 0, -1, 0};
		int [] dy = {0, 1, 0, -1};

		int direction = 0;

		int x = 0;  // 시작 위치 (0, 0)
		int y = 0;

		arr[x][y] = currentNumber--;  // 첫 번째 칸에 숫자 넣기

		// 나선형으로 배열 채우기
		while (currentNumber > 0) {

			int tmp_x = x + dx[direction];  // 새로운 x 좌표
			int tmp_y = y + dy[direction];  // 새로운 y 좌표

			// 이동할 위치가 범위 안에 있고, 해당 위치가 비어있다면
			if (tmp_x >= 0 && tmp_x < size &&
				tmp_y >= 0 && tmp_y < size &&
				arr[tmp_x][tmp_y] == 0)
			{
				arr[tmp_x][tmp_y] = currentNumber--;  // 숫자 채우기

				x = tmp_x;
				y = tmp_y;

			}
			else
			{
				// 방향 변경 (0~3)
				direction = (direction + 1) % 4;
			}
		}

		StringBuilder sb = new StringBuilder();

		int q = 0;
		int w = 0;

		// 배열 출력 (행 끝에 불필요한 공백을 없애기 위해 조정)
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				if(arr[i][j] == number)
				{
					q= i+1;
					w= j+1;
				}
				sb.append(arr[i][j]);
				if (j != size - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}

		// 찾은 숫자의 좌표 출력
		sb.append(q).append(" ").append(w);

		// 출력
		System.out.println(sb.toString());
	}
}
