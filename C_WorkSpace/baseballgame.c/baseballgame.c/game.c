#include<stdio.h>                                                                                                                                                                                                                                                                                                                                                                                                                   
#include<string.h>
#include<time.h>


//�� ������
void info()
{
	puts("\n\n\n---------------------------��---------------------------------\n");
	puts("1~9������ ���� �� ���ϴ� ���� 3������ �Է��Ͽ�\n");
	puts("�������� ������ ���� 3������ ã�ư��� �����Դϴ�.\n");
	puts("[������ ����] 3������ ���� �ߺ����� ������\n");
	puts("���ϴ� ���� 3������ �Է��� �� ���� �ߺ��� ���ڸ� �Է��ؼ� �ȵ˴ϴ�.\n");
	puts("������ ���� ���� ������ ���ڸ� �ùٸ� ������ ���� �Է��ؾ��ϸ�\n");
	puts("1. ���ڸ� �������� �ڸ��� �ٸ��ٸ� ��.��\n");
	puts("2. ���ڿ� �ڸ� ��� ����ٸ� ��Ʈ����ũ.��\n");
	puts("ex)\n");
	puts("1\t2\t3(������ ����)\n");
	puts("3\t2\t4(�Է��� ����)\n");
	puts("3�� �������� �ڸ��� Ʋ�����Ƿ� 1��.��");
	puts("2�� �ڸ��� ���� ��� �������Ƿ� 1��Ʈ����ũ.��\n");
	puts("��ȸ�� �� ���ӿ� �� 20������ �����˴ϴ�.\n");
	puts("20���� ��ȸ ���� 3��Ʈ����ũ�ܡܡܸ� ã�Ƴ��� ���� �� ������ ��ǥ�Դϴ�.\n\n");
}

//1~9���� ���� �߻�
int getNumber()
{
	return rand() % 9 + 1;
}

//���,�����÷ο� üũ
int flowcheck(int ck)
{
	if (ck <= 0 || ck > 9)
		return 0;

}

//������� üũ
int exitcheck(int ck)
{
	if (ck == 0)
		return 0;
}

//�Է¹��� ���� �׽�Ʈ
int numtest(int* num[])
{
	int getnum;
	char ck = 'N';

	for (int i = 0;i < 3;)
	{
		printf("%d��° ���ڸ� �Է����ּ��� :", i + 1);
		scanf_s("%d", &getnum);

		if (exitcheck(getnum) == 0)
			return 0;
		if (flowcheck(getnum) == 0)

		{
			puts("\n1~9������ ���� �� �ϳ��� �������ּ���.\n");
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
			puts("\n�ߺ��� ���� �ԷµǾ����ϴ�.\n�ٸ� ���ڸ� �Է��ϼ���.\n");
		ck = 'N';

	}

	printf("\n�Էµ� ��ȣ :");

	for (int t = 0; t < 3; t++)
		printf("%3d", num[t]);
	printf("\n\n");
}

//���� 3�ڸ� �ޱ�
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

//�� üũ
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

	printf("%d��, %d��Ʈ����ũ!\n", bst, sst);
	for (a = 0; a < 3 - (bst + sst);a++)
		printf("��");
	for (a = 0; a < bst;a++)
		printf("��");
	for (a = 0; a < sst;a++)
		printf("��");
	printf("\n\n\n", sst);

	if (sst == 3)
		return 0;
}

//Ÿ��Ʋ
void title()
{
	printf("=============================================================\n");
	printf("=                                                           =\n");
	printf("=		        �ھ߱� ���ӡ�                       =\n");
	printf("=                                                           =\n");
	printf("=============================================================\n\n");
}

//�޴�(�� ����,����, ��Ģ ����)
int mede()
{
	while (1)
	{
		int ck;
		printf("\n\n                  ======================\n");
		printf("                  =                    =\n");
		printf("                  =     1.�� ����      =\n");
		printf("                  =     2.����         =\n");
		printf("                  =     3.���ӱ�Ģ     =\n");
		printf("                  =                    =\n");
		printf("                  ======================\n\n");
		printf("                ���Ͻô� �޴��� �Է��ϼ��� : ");
		scanf_s(" %d", &ck);

		if (ck == 1)			//�� ����
		{
			return 1;
			break;
		}
		else if (ck == 2)		//����
		{
			puts("\n������ �����մϴ�.\n�̿����ּż� �����մϴ�.");
			return 2;
		}
		else if (ck == 3)		//��Ģ ����
			info();
	}
}

//���� ȣ��
void col(int* conum[])
{
	printf("                  ������");

	for (int f = 0;f < 3;f++)
	{
		printf("%3d", conum[f]);
	}
	puts("�����ϴ�.");
}

int main()
{
	int conum[3], mynum[3], i = 1, choose = 0;
	char sel;

	title();
	if(mede()==2)
		return 0;

	puts("\n\n��Play Ball! ���ݺ��� ������ �����մϴ�.");
	puts("���� �Ǵ� ������� ���Ͻø� 0���� �����ּ���.��\n");

	while (1)
	{
		srand((unsigned)time(NULL));	//���� ���� 3�� �ޱ�
		randnum(conum);
		while (1)
		{
			printf("%dȸ ����!\n", i);
			
			//���Է�&��� ����� �޴� ȣ��
			if (numtest(mynum) == 0)	//���� �����ϱ�& ����,����� ���� Ȯ��
			{
				if (mede() == 2)
					return 0;
				else
				{
					printf("\n\n               ��������");
					for (int f = 0;f < 3;f++)
					{
						printf("%3d", conum[f]);
					}
					puts("�����ϴ�.��");
					puts("\n                   ������ ������մϴ�.\n\n");
					i = 1;
					break;
				}
			}

			//���� �Ǻ�& ����� �޴� ȣ��
			if (coltest(mynum, conum) == 0)	//���� �Ǻ��ϱ�
			{
				puts("\n\n              �١ڡ١ڡ١������Դϴ١ڡ١ڡ١�\n\n");
				col(conum);

				if (mede() == 2)
				{
					return 0;
				}
				else
				{
					puts("\n������ ������մϴ�.\n\n");
					i = 1;
					break;
				}
			}
			
			//15 ��ȸ ��� ���� GameOver&�޴� ȣ��
			if (i >= 15)						
			{
				puts("\n              15���� ��ȸ�� ��� ����Ͽ����ϴ�.\n");
				puts("\n                 Game Over....\n\n\n");
				col(conum);

				if (mede() == 2)
				{
					return 0;
				}
				else
				{
					puts("\n������ ������մϴ�.\n\n");
					i = 1;
					break;
				}


			}						

			i++;
		}
	}
}