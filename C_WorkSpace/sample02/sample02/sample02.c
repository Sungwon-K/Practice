#include<stdio.h>                                                                                                                                                                                                                                                                                                                                                                                                                   
#include<string.h>
#include<malloc.h>
#include<time.h>
//#include "myheader.h"

#define PI 3.1415926535
#define STR "���� ������ ����߽��ϴ�.\n"
#define END_MSG printf("���α׷��� ����Ǿ����ϴ�.\n\n")

void func();

int a;


int main(int argc, char* argv[])
{
	//�����Լ� �Ű�����
	/*
	char str[200];
	FILE* rfp;

	if (argc != 2)
	{
		printf("---�Ű������� 1�� ����ϼ���---\n");
		return -1;
	}

	fopen_s(&rfp, argv[1], "r");

	for (;;)
	{
		fgets(str, 199, rfp);
		if (feof(rfp))
			break;
		printf("%s", str);
	}

	fclose(rfp);
	*/

	//��� ����
	/*
	func(10);
	*/

	//c���� ȣ��
	/*
	func1();
	func2();
	*/
	
	//define�� ���
	/*
	printf("�������� 10�� ���� ���� : %10.5d\n", 10 * 10 * PI);

	printf(STR);
	END_MSG;
	*/

	//extern ����� ���
	/*
	a = 100;
	func();
	*/

	//
	char str[200];
	FILE* rfp, *wfp;

	if (argc != 3)
	{
		printf("\n--�Ű������� 2�� ����ϼ���--\n");
		return 0;
	}

	fopen_s(&rfp, argv[1], "r");
	fopen_s(&wfp, argv[2], "w");

	for (;;)
	{
		fgets(str, 199, rfp);

		if (feof(rfp))
			break;

		fputs(str, wfp);
	}

	fclose(rfp);
	fclose(wfp);
}




