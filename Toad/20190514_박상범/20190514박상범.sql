����1
�����ž��� �����ϰ� �ִ� ���ϸ��� ����Ʈ�� ���� ��
�ִ� ��ǰ �� ���� ����Ʈ�� ���� ��ǰ��� ����Ʈ��
����ϴ� SQL���� �ۼ��Ͻÿ�.

1�� ����

SELECT name_vc "���� ���� ��ǰ��", point_nu "�ش� ����Ʈ"
    FROM t_giftpoint
   WHERE point_nu IN (SELECT max(P.point_nu) FROM t_giftmem M, t_giftpoint P 
                        WHERE M.point_nu >= P.point_nu AND M.name_vc='������');
2�� ����         
        
SELECT P.point_nu, P.name_vc, M.name_vc
    FROM (SELECT * FROM t_giftmem WHERE name_vc='������') M, t_giftpoint P       
   WHERE P.point_nu = (SELECT MAX(t_giftpoint.point_nu) 
                        FROM t_giftpoint
                        , (SELECT * FROM t_giftmem WHERE name_vc='������') M
                         WHERE M.point_nu>=t_giftpoint.point_nu)
                        
      
                        
FROM�� ���̺��� �ΰ� �� �ʿ䰡 ����.

����2
C:\������Ʈ����\01. ����Ŭ_����\����Ŭ�ǽ��ҽ�\SQL\04��
t_worktime���̺� �߰��ϱ�

t_worktime���� �۾��ڵ�� �۾��ð� ������ ��� �ִ�.
rank()�� ���� �Լ��� ������� ����
�۾��ð��� ª�� �ɸ��� �ð� ������� 1���� 15������
������ �Űܼ� ����Ͻÿ�.

��°��

�۾��ڵ�  �۾��ð�  ����
---------------------------

SELECT a.time_nu , b.time_nu
FROM t_worktime a, t_worktime b
ORDER BY a.time_nu asc, b.time_nu;

WHERE one.time_nu>two.time_nu
GROUP BY two.seq_vc

ORDER BY one.time_nu , two.time_nu;


 
SELECT workcd_vc �۾��ڵ�, b.time_nu �۾��ð�
       , (SELECT count(*) +1
         FROM t_worktime  WHERE time_nu < b.time_nu) rank
     FROM t_worktime b
     ORDER BY rank asc
     
SELECT workcd_vc �۾��ڵ�, b.time_nu �۾��ð�
       , (SELECT count(*) +1
         FROM t_worktime  WHERE time_nu < b.time_nu) rank
     FROM t_worktime b
     
���ذ� ���� ���� ����.