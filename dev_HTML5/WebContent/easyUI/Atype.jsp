<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- BasicType���� �µ�ȿ��� ���� ���� -->

<!--
	javascript�ڵ�� html�±׾ȿ� ���� �� �� �ִ�. (head�±� ��, body�±� ��)
	�� ��ġ�� ���̴�??
		head�±��� javascript�� ������ �� �����
			( ����-�������� , �Լ� ) : ���� �� �ҷ��� �����
		body�±��� javascript�� ���� �θ��� �ʾƵ� �����
			: ���ǻ��� ! DOM������ ���� ( ���� �� ��� /���� �� ȣ�� )
			: DOM������ ������ �������� �˰� �ִ�.
	
	1)DOM������ �Ϸ�Ǿ��� ���� ���������� �����ʹ�.-ready() ȣ��
	2)�Լ��� �Ķ���� �ڸ����� �ڵ�����(����)�� �����ϴ�.-���ǻ��� : �¿��߰�ȣ�� ������ ����ǥ�� ( {} )
	3)���߰�ȣ�� ���߰�ȣ�ȿ��� �Ӽ��߰�, �̺�Ʈó��(�̺�Ʈ����)�� �����ϴ�
-->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>A TYPE</title>

<!-- js���ϰ� css���� import -->
	<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	
</head>
<body><!-- ȭ�鿡 �����ֱ����� body�±׸� ���� -->
<table border="1" width="500px" class="easyui-datagrid" title = "�޽���">
	<thead>
		<tr>
			<th data-options="field:'nickName',width:120,align:'center'">��ȭ��</th>
			<th data-options="field:'roomName',width:200">���̸�</th>
			<th data-options="field:'status',width:120">��ȭ��</th>
		</tr>
	</thead>
	<tbody>
        <tr>
            <td>001</td><td>name1</td><td>2323</td>
        </tr>
        <tr>
            <td>002</td><td>name2</td><td>4612</td>
        </tr>
    </tbody>
</table>
</body>
</html>