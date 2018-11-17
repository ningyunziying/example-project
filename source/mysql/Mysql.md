

# MySQL(v8.0)

##  一、基本数据类型

### 1.String Literals(字符常量)

#### 1.1简介

字符串就是用单引号或双引号进行修饰的字符，单引号和双引号的作用是一样的。

```
'a String' 和"a String"
```

相邻的两个字符串可自动进行拼接

```
'a' ' ' 'string'<=>'a'+' '+'string'
"a" " " "string"<=>'a'+' '+'string'
"a" " " "string"<=>'a' ' ' 'string'
```

**注：如果ANSI_QUOTES SQL模式开启，则只能用单引号，因为双引号会被理解为一个标识符**

以下列出转义字符

| Escape Sequence | Character Represented by Sequence      |
| --------------- | -------------------------------------- |
| \0              | An ASCII NUL (X'00') character         |
| \'              | A single quote (') character一个单引号 |
| \"              | A double quote (") character一个双引号 |
| \b              | A backspace character 退格             |
| \n              | A newline (linefeed) character 换行    |
| \r              | A carriage return character            |
| \t              | A tab character                        |
| \\              | A backslash (\) character              |
| \%              | A % character;                         |
| \_              | A _ character;                         |

#### 1.2 支持类型

字符串类型包含： CHAR, VARCHAR, BINARY, VARBINARY, BLOB, TEXT, ENUM, SET 8种

**CHAR, VARCHAR**

当VARCHAR(4)和CHAR(4)存储的位数不够4位时，检索出的数据依赖于检索的方式，这时会出现问题。

索然我们在数据后插入了空格，但是varchar给去掉了。

```
mysql> CREATE TABLE vc (v VARCHAR(4), c CHAR(4));
Query OK, 0 rows affected (0.01 sec)
mysql> INSERT INTO vc VALUES ('ab ', 'ab ');
Query OK, 1 row affected (0.00 sec)
mysql> SELECT CONCAT('(', v, ')'), CONCAT('(', c, ')') FROM vc;
+---------------------+---------------------+
| CONCAT('(', v, ')') | CONCAT('(', c, ')') |
+---------------------+---------------------+
| (ab ) | (ab) |
+---------------------+---------------------+
1 row in set (0.06 sec)
```

```
mysql> CREATE TABLE names (myname CHAR(10));
Query OK, 0 rows affected (0.03 sec)
mysql> INSERT INTO names VALUES ('Monty');
Query OK, 1 row affected (0.00 sec)
mysql> SELECT myname = 'Monty', myname = 'Monty ' FROM names;
+------------------+--------------------+
| myname = 'Monty' | myname = 'Monty ' |
+------------------+--------------------+
| 1 | 1 |
+------------------+--------------------+
1 row in set (0.00 sec)
mysql> SELECT myname LIKE 'Monty', myname LIKE 'Monty ' FROM names;
+---------------------+-----------------------+
| myname LIKE 'Monty' | myname LIKE 'Monty ' |
+---------------------+-----------------------+
| 1 | 0 |
+---------------------+-----------------------+
1 row in set (0.00 sec)
```

**以上的这个例子在MySQL 8中已经没有了~**

**The BINARY and VARBINARY Types**

//TODO 2018年11月17日20:13:16


### 2.Numberic Literals(数值常量)

数值可以包含精确值(exact-value ：integer and DECIMAL)和近似值（approximate-value：floating-point）

精确值可以表示为：

```
1, .2, 3.4, -5, -6.78, +9.10.
```

近似值可以表示为：

```
1.2E3, 1.2E-3, -1.2E3, -1.2E-3.
```

有些相同的数值因为写法不同，就不同对待比如：2.34-精确值和2.34E0-近似值

具体的数据类型在以下会提到。

### 3.Date and Time Literals(日期和时间常量)

日期类型和时间类型可以有不同的表现形式：'2015-07-21', '20150721', 20150721 都可以作为日期去表现。

标准的解析语法如下

```
DATE 'str'
TIME 'str'
TIMESTAMP 'str'
```

MySQL也兼容ODBC的写法

```
{ d 'str' }
{ t 'str' }
{ ts 'str' }
```

*例子：*

*SELECT {d'20070523'}; 结果为：2007-05-23*
d:DATE
t:TIME
ts:DATETIME

对于日期格式**DATE**

(1)带分隔符的字符串：'YYYY-MM-DD' , 'YY-MM-DD' 2012-12-31', '2012/12/31', '2012^12^31', '2012@12@31'

(2)不带分隔符的字符：‘YYYYMMDD' or 'YYMMDD' 。但071332不是有效的类型，因为他包含了非法的月份。

但最好不要这么做，因为'070405'具体是哪一年是不确定的，我在测试中发现是转为2007-04-05。

(3)不带分隔符的数值：YYYYMMDD 或YYMMDD

对于时间或日期时间**TIME DATETIME**

(1)带分隔符的字符串：'YYYY-MM-DD HH:MM:SS', 'YY-MM-DD HH:MM:SS', '2012-12-31 11:30:45', '2012^12^31 11+30+45', '2012/12/31/11*30*45',  '2012@12@31 11^30^45'

'2012-12-31T11:30:45'日期和时间之间也可以为'T'

(2)不带分隔符的字符串：'YYYYMMDDHHMMSS','YYMMDDHHMMSS'

(3)不带分隔符的数值：YYYYMMDDHHMMSS,YYMMDDHHMMSS

• Year values in the range 70-99 are converted to 1970-1999.
• Year values in the range 00-69 are converted to 2000-2069.

MySQL支持微秒的获取：'D HH:MM:SS.fraction'，其中fraction是一个6为的微秒

### 4.Hexadecimal Literals(十六进制常量)

十六进制可以写为：**X'val' or 0xval**，其中**'X'**必须大写,**'0x'**必须小写

对于val部分可以为:(0..9, A..F),以**'X'**开头的位数必须为偶数（even number）

但以**'0x'**不要求

比如以下：

```
X'0FFF'正确，X'FFF'错误
0xaaa<==>0x0aaa
```

因为以0x开头的都是前位进行补0对其。

默认的十六进制都是一个二进制的String，之所以不一样是因为默认的字符集是

```
SELECT X'4D7953514C', CHARSET(X'4D7953514C');
MySQL binary
```
如果要把十六进制转换为数字，会转换为BIGINT (64-bit integer).notation（标识符）

```
mysql> SET @v1 = X'41';
mysql> SET @v2 = X'41'+0;
mysql> SET @v3 = CAST(X'41' AS UNSIGNED);
mysql> SELECT @v1, @v2, @v3;
+------+------+------+
| @v1 | @v2 | @v3 |
+------+------+------+
| A | 65 | 65 |
+------+------+------+
```

如果想把一个字符串转换为十六进制：HEX()函数可以做到。

### 5.Bit-Value Literals(二进制常量)

和十六进制类似，不再赘述，只贴一些例子

```
mysql> SELECT b'1000001', CHARSET(b'1000001');
+------------+---------------------+
| b'1000001' | CHARSET(b'1000001') |
+------------+---------------------+
| A | binary |
+------------+---------------------+
mysql> SELECT 0b1100001, CHARSET(0b1100001);
+-----------+--------------------+
| 0b1100001 | CHARSET(0b1100001) |
+-----------+--------------------+
| a | binary |
+-----------+--------------------+
```



```
mysql> SET @v1 = b'1100001';
mysql> SET @v2 = b'1100001'+0;
mysql> SET @v3 = CAST(b'1100001' AS UNSIGNED);
mysql> SELECT @v1, @v2, @v3;
+------+------+------+
| @v1 | @v2 | @v3 |
+------+------+------+
| a | 97 | 97 |
+------+------+------+
```



```
mysql> SELECT b+0, BIN(b), OCT(b), HEX(b) FROM t;
+------+----------+--------+--------+
| b+0 | BIN(b) | OCT(b) | HEX(b) |
+------+----------+--------+--------+
| 255 | 11111111 | 377 | FF |
| 10 | 1010 | 12 | A |
| 5 | 101 | 5 | 5 |
+------+----------+--------+--------+
```



```
mysql> SET @v1 = b'000010101' | b'000101010';
mysql> SET @v2 = _binary b'000010101' | _binary b'000101010';
mysql> SELECT HEX(@v1), HEX(@v2);
+----------+----------+
| HEX(@v1) | HEX(@v2) |
+----------+----------+
| 3F | 003F |
+----------+----------+
```



### 6.Boolean Literals（布尔值常量）

布尔变量TRUE和FALSE等价于1和0，不区分大小写。

```
mysql> SELECT TRUE, true, FALSE, false;
-> 1, 1, 0, 0
```

*我试过TrUe也是合法的*

### 7.NULL Values（空值）

NULL意味着没值”no data“,NULL不区分大小写。

### 8.对其他类型的支持（JSON）

## 二、InnoDB

## 附录：MySQL安装

1.在CentOS7中安装MySQL8



