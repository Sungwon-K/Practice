#include<stdio.h>                                                                                                                                                                                                                                                                                                                                                                                                                   
#include<string.h>
#include<malloc.h>
#include<time.h>


int main()
{
	//malloc ���
	/*
	int* p;
	int i, sum = 0, cnt;

	printf("�Է��� ������?");
	scanf_s("%d", &cnt);

	p = (int*)malloc(sizeof(int) * cnt);

	for (i = 0;i < cnt;i++)
	{
		printf("%d ��° ���� : ", i + 1);
		scanf_s("%d", &p[i]);
	}

	for (i = 0;i < cnt;i++)
		sum += p[i];
	printf("�Է� ���� �� : %d\n", sum);

	free(p);
	*/

	//realloc() ���
	/*
	int* p;
	int i, sum = 0, cnt = 0, data;

	p = (int*)malloc(sizeof(int) * 1);
	printf("1 ��° ���� : ");
	scanf_s("%d", &p[0]);
	cnt++;

	for (i = 2;;i++)
	{
		printf("%d��° ���� : ", i);
		scanf_s("%d", &data);

		if (data != 0)
			p = (int*)realloc(p, sizeof(int) * i);
		else
			break;

		p[i - 1] = data;
		cnt++;
	}

	for (i = 0; i < cnt; i++)
		sum += p[i];

	printf("�Է� ���� �� : %d\n", sum);

	free(p);
	*/

	//������ �迭�� ���
	/*
	char* p[3];
	char imsi[100];
	int i, size;

	for (i = 0;i < 3;i++)
	{
		printf("%d��° ���ڿ� : ", i + 1);
		gets_s(imsi, 100);

		size = strlen(imsi);
		p[i] = (char*)malloc((sizeof(char) * size) + 1);

		strcpy_s(p[i], size + 1, imsi);

	}

	printf("\n--�Է°� �ݴ�� ���(������)--\n");
	for(i = 2;i >= 0;i--)
	{
		printf("%d:%s\n", i + 1, p[i]);
	}

	for (i = 0;i < 3;i++)
		free(p[i]);
	*/

	//������ �迭 ���2
	/*
	char* p = "Hello World";
	char p[] = "Hello World";

	printf("%s\n", p);
	printf("%c\n", *(p+0));
	printf("%c\n", p[0]);
	printf("%c\n", *(p+1));
	printf("%c\n", p[1]);
	*/

	//����ü ���
	struct bibim
	{
		int a;
		float b;
		char c;
		char d[5];
	};

	struct bibim b1;

	b1.a = 10;
	b1.b = 1.1f;
	b1.c = 'A';
	strcpy_s(b1.d, 5, "ABCD");

}