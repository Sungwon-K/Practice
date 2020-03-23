#include<stdio.h>                                                                                                                                                                                                                                                                                                                                                                                                                   
#include<string.h>
#include<time.h>


//룰 디자인
void info()
{
	puts("\n\n\n---------------------------룰---------------------------------\n");
	puts("1~9까지의 숫자 중 원하는 숫자 3가지를 입력하여\n");
	puts("무작위로 지정된 숫자 3가지를 찾아가는 게임입니다.\n");
	puts("[지정된 숫자] 3가지는 서로 중복되지 않으며\n");
	puts("원하는 숫자 3가지를 입력할 때 역시 중복된 숫자를 입력해선 안됩니다.\n");
	puts("정답을 맞출 때는 정해진 숫자를 올바른 순서에 맞춰 입력해야하며\n");
	puts("1. 숫자를 맞췄지만 자리가 다르다면 볼.◎\n");
	puts("2. 숫자와 자리 모두 맞췄다면 스트라이크.●\n");
	puts("ex)\n");
	puts("1\t2\t3(지정된 숫자)\n");
	puts("3\t2\t4(입력한 숫자)\n");
	puts("3을 맞췄지만 자리가 틀렸으므로 1볼.◎");
	puts("2는 자리와 숫자 모두 맞췄으므로 1스트라이크.●\n");
	puts("기회는 한 게임에 총 20번까지 제공됩니다.\n");
	puts("20번의 기회 동안 3스트라이크●●●를 찾아내는 것이 이 게임의 목표입니다.\n\n");
}

//1~9숫자 난수 발생
int getNumber()
{
	return rand() % 9 + 1;
}

//언더,오버플로우 체크
int flowcheck(int ck)
{
	if (ck <= 0 || ck > 9)
		return 0;

}

//긴급종료 체크
int exitcheck(int ck)
{
	if (ck == 0)
		return 0;
}

//입력받은 숫자 테스트
int numtest(int* num[])
{
	int getnum;
	char ck = 'N';

	for (int i = 0;i < 3;)
	{
		printf("%d번째 숫자를 입력해주세요 :", i + 1);
		scanf_s("%d", &getnum);

		if (exitcheck(getnum) == 0)
			return 0;
		if (flowcheck(getnum) == 0)

		{
			puts("\n1~9사이의 숫자 중 하나를 선택해주세요.\n");
			continue;
		}

		for (int k = 0;k < i;k++)
		{
			if (num[k] == getnum)
				ck = 'Y';
		}

		if (ck == 'N')
		{
			num[i] = getnum;
			i++;
		}
		else
			puts("\n중복된 값이 입력되었습니다.\n다른 숫자를 입력하세요.\n");
		ck = 'N';

	}

	printf("\n입력된 번호 :");

	for (int t = 0; t < 3; t++)
		printf("%3d", num[t]);
	printf("\n\n");
}

//난수 3자리 받기
int randnum(int* num2[])
{
	int num;
	char dup = 'N';

	for (int i = 0;i < 3;)
	{
		num = getNumber();
		for (int k = 0;k < i;k++)
		{
			if (num2[k] == num)
				dup = 'Y';
		}

		if (dup == 'N')
		{
			num2[i] = num;
			i++;
		}
		else
			dup = 'N';
	}
}

//답 체크
int coltest(int* mnum, int* cnum)
{
	int bst = 0, sst = 0, a, b;

	for (a = 0; a < 3;a++)
	{
		for (b = 0; b < 3;b++)
		{
			if (mnum[a] == cnum[b])
			{
				if (a == b)
					sst += 1;
				else
					bst += 1;
			}
		}
	}

	printf("%d볼, %d스트라이크!\n", bst, sst);
	for (a = 0; a < 3 - (bst + sst);a++)
		printf("○");
	for (a = 0; a < bst;a++)
		printf("◎");
	for (a = 0; a < sst;a++)
		printf("●");
	printf("\n\n\n", sst);

	if (sst == 3)
		return 0;
}

//타이틀
void title()
{
	printf("=============================================================\n");
	printf("=                                                           =\n");
	printf("=		        ★야구 게임☆                       =\n");
	printf("=                                                           =\n");
	printf("=============================================================\n\n");
}

//메뉴(새 게임,종료, 규칙 선택)
int mede()
{
	while (1)
	{
		int ck;
		printf("\n\n                  ======================\n");
		printf("                  =                    =\n");
		printf("                  =     1.새 게임      =\n");
		printf("                  =     2.종료         =\n");
		printf("                  =     3.게임규칙     =\n");
		printf("                  =                    =\n");
		printf("                  ======================\n\n");
		printf("                원하시는 메뉴를 입력하세요 : ");
		scanf_s(" %d", &ck);

		if (ck == 1)			//새 게임
		{
			return 1;
			break;
		}
		else if (ck == 2)		//종료
		{
			puts("\n게임을 종료합니다.\n이용해주셔서 감사합니다.");
			return 2;
		}
		else if (ck == 3)		//규칙 보기
			info();
	}
}

//정답 호출
void col(int* conum[])
{
	printf("                  정답은");

	for (int f = 0;f < 3;f++)
	{
		printf("%3d", conum[f]);
	}
	puts("였습니다.");
}

int main()
{
	int conum[3], mynum[3], i = 1, choose = 0;
	char sel;

	title();
	if(mede()==2)
		return 0;

	puts("\n\n☆Play Ball! 지금부터 게임을 시작합니다.");
	puts("종료 또는 재시작을 원하시면 0번을 눌러주세요.★\n");

	while (1)
	{
		srand((unsigned)time(NULL));	//지정 숫자 3개 받기
		randnum(conum);
		while (1)
		{
			printf("%d회 시작!\n", i);
			
			//값입력&긴급 종료시 메뉴 호출
			if (numtest(mynum) == 0)	//숫자 지정하기& 종료,재시작 여부 확인
			{
				if (mede() == 2)
					return 0;
				else
				{
					printf("\n\n               ☆정답은");
					for (int f = 0;f < 3;f++)
					{
						printf("%3d", conum[f]);
					}
					puts("였습니다.★");
					puts("\n                   게임을 재시작합니다.\n\n");
					i = 1;
					break;
				}
			}

			//정답 판별& 정답시 메뉴 호출
			if (coltest(mynum, conum) == 0)	//숫자 판별하기
			{
				puts("\n\n              ☆★☆★☆★정답입니다★☆★☆★\n\n");
				col(conum);

				if (mede() == 2)
				{
					return 0;
				}
				else
				{
					puts("\n게임을 재시작합니다.\n\n");
					i = 1;
					break;
				}
			}
			
			//15 기회 모두 사용시 GameOver&메뉴 호출
			if (i >= 15)						
			{
				puts("\n              15번의 기회를 모두 사용하였습니다.\n");
				puts("\n                 Game Over....\n\n\n");
				col(conum);

				if (mede() == 2)
				{
					return 0;
				}
				else
				{
					puts("\n게임을 재시작합니다.\n\n");
					i = 1;
					break;
				}


			}						

			i++;
		}
	}
}