// ����� �����մϴ�.
var mysql = require('mysql');

// �����ͺ��̽��� �����մϴ�.
var client = mysql.createConnection({
  user: 'root',
  password: '1234',
  database: 'Company'
});

// �����ͺ��̽� ������ �����մϴ�.
client.query('SELECT * FROM products', function (error, result, fields) {
  if (error) {
    console.log(error);
  } else {
    console.log(result);
  }
});