1.1.�� �޿��� ������ 18�� ������ Ȧ�� �޿��� ������ 1/18�� ���޵ǰ�, ¦���޿��� ������
2/18�� ���޵ȴٰ� �������� �� Ȧ�� �ް� ¦�� �޿� ���� �ݾ��� ��Ÿ���ÿ�.

SELECT salary*1/18 as "Ȧ�� ��", salary*2/18 as "¦�� ��"
    FROM temp;

 2.������ ���� �� �޿��� ����� 10������ ���޵ȴٸ�(¦������ 20����)���� ������ 
��� �ٲ��� �ۼ��� ���ÿ�.

SELECT salary*1/18+10 as "Ȧ�� ��(+�����)", salary*2/18+20 as "¦�� ��(+�����)"
    FROM temp;

3.TEMP ���̺��� ��̰� NULL �� �ƴ� ����� ������ �о���ÿ�.


SELECT emp_name as �̸� FROM temp WHERE hobby is not null;
 
4.TEMP ���̺��� ��̰� NULL�� ����� ��� HOBBY�� ���������̶�� ���� ġȯ�Ͽ� 
�������� �������� �״�� ���� �о���ÿ�.

SELECT nvl(hobby,'����') as ��� FROM temp ;
  
5.TEMP�� �ڷ� �� HOBBY�� ���� NULL�� ����� ����ꡯ���� ġȯ���� �� HOBBY�� �������
����� ������ �������� ������ �ۼ��Ͻÿ�.

SELECT emp_name as �̸�, nvl(hobby,'���') as "���=���"
    FROM temp
    WHERE nvl(hobby,'���')='���';
 
6.TEMP�� �ڷ� �� EMP_ID�� EMP_NAME�� ���� �������,���������� ǥ�õǾ� DISPLAY�ǵ���
COLUMN ALLIAS(~��� �������� �ҷ���)�� �ο��Ͽ� SELECT �Ͻÿ�.

SELECT emp_id as ���, emp_name as ����
    FROM temp;

7.����� ��������� ��������ǥ�� ��� �ϳ��� ���ڿ��� �����ִ� ������ ����� ���ÿ�.

SELECT CHR(96)||emp_name||birth_date||CHR(96) as "����� �������"
FROM temp ;

--EDIT TEMP

--SELECT CHR(96) ||1995||CHR(65) FROM dual --�ƽ�Ű �ڵ�ǥ ����
  
8.TEMP�� �ڷḦ ���� ��(LEV)�� ASCENDING�ϸ鼭 ��������� �ٽ� ��� ������ 
DESCENDING�ϰ� �ϴ� ORDER BY�ϴ� ������ ����� ���ÿ�.

SELECT lev as ����, emp_id as ���
    FROM temp
   ORDER BY lev asc, emp_id desc