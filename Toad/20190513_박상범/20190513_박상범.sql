����1
��ȭƼ���� ���� �� �ִ� ����� ��ܰ� ���� ������
�ִ� ����Ʈ, ��ȭƼ���� ����Ʈ �׸��� ��� ��
�ܿ�����Ʈ�� ����ϴ� SQL���� �ۼ��Ͻÿ�.

A��� (WHERE�� ���� �ΰ�)

SELECT t_giftmem.name_vc "���� �� �ִ� ���"
    ,t_giftmem.point_nu "������Ʈ"
    ,t_giftpoint.point_nu "��ȭƼ�� ����Ʈ"
    ,t_giftmem.point_nu-t_giftpoint.point_nu "�ܿ� ����Ʈ"
     FROM t_giftmem, t_giftpoint
  WHERE t_giftpoint.name_vc='��ȭƼ��'
  AND t_giftmem.point_nu>=t_giftpoint.point_nu;  
  
B���.(WHERE�� ������ �ϳ� �پ��)

SELECT A.name_vc "Ƽ�� ���ɰ�����"
      ,A.point_nu "������Ʈ"
      ,B.point_nu "��ȭƼ�� ����Ʈ"
      ,A.point_nu-B.point_nu "�ܿ�����Ʈ"
    FROM t_giftmem A, (SELECT point_nu FROM t_giftpoint WHERE name_vc='��ȭƼ��') B
  WHERE A.point_nu>=B.point_nu;
