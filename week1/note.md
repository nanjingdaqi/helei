#week_1
 ---
###  1. Java class/interface的extends/implements的知识点，包括各种内部类
* ##### class&extends

class
每个类文件最多只能有一个public类，且与文件名同名。


```
//类定义
  class Father{        
      数据成员：
       [修饰符] 类型 变量名 [=?]     
      成员函数：
       访问控制符 [修饰符] 返回值类型 方法名称(参数列表){  
         方法体
       }
      构造器
    }
```  
```
//创建类型新对象
  Father f=new Father()；
```



```
//extends(子类继承父类)
class Son1 extends Father{

  }
```


* ##### interface&implements




* ##### 内部类
在外部类的内部定义的类，成员内部类(Inner1)、局部内部类(在内部方法里)、匿名内部类(Inner3)和静态内部类。
静态内部类可参考static，内部类里不能访问外部的非静态成员。



### 2.静态变量 （StaticDemo）
static，用于成员，函数，代码块，内部类，将对象相关的变成类相关的，static修饰的东西在类加载的时候自动初始化。

静态变量（&局部变量&实例变量）：
局部变量是指不直接声明在类体括号里面的变量，只作用在定义它的代码块里。
实例变量无static修饰，但需要借助实例对象。
static变量只会被创建一次。

静态函数：类内直接调用方法，不需借助对象；类外直接用类名.方法名 调用。

静态内部类：直接new，非静态类需创建一个父类的实例。


### 3. final的使用
final <br>
修饰变量，基本数据类型不可以改变，句柄不可以改变指向位置，但指向位置的值可以改变<br>
修饰方法，方法不能被重写<br>
修饰类，该类不能被其他类继承。


### 4.public/private/protected的说明
修饰符>访问控制修饰符

|  |   |  |
| ------------- |:-------------:| -----:|-----:|
|public|（类，成员，函数，接口）|对所有包可见|
|protected|（成员，函数）| 包内以及子类可见
|default（friendly）|（类，成员，函数，接口）| 同一包内可见
| private|（成员，函数）|同一个类可见


### 5.原始数据类型，自动装箱机制
* ##### 原始数据类型

| 主类型         |bit            | 封装器类型 |默认值|
| ------------- |:-------------:| -----:|-----:|
| byte     | 8| Byte|null |
| short   | 16  | Short|  0|
| int | 32     | **Integer**|  0|
| long|64    | Long|   0|
| float     |32  |Float|  0|
| double|64      |Double |  0|
| char     | 16    |**Character** |  0|
| boolean| 1     |Boolean |false|



> 复杂类型和基本类型的内存模型本质上是不一样的，简单数据类型的存储原理是这样的：所有的简单数据类型不存在“引用”的概念，简单数据类型都是直接存储在内存中的内存栈上的，数据本身的值就是存储在栈空间里面，而Java语言里面只有这八种数据类型是这种存储模型；而其他的只要是继承于Object类的复杂数据类型都是按照Java里面存储对象的内存模型来进行数据存储的，<br>Integer a = new Integer(1);
表示一个Integer类型的引用a引用了一块内存，这块内存中的数据是1; 而a中所存的则是这块内存的引用（地址），把a传给别的方法或对象时，则是把a的引用传递过去了。
使用Java内存堆和内存栈来进行这种类型的数据存储，简单地讲，“引用”(Integer a)是存储在有序的内存栈上的，而对象本身的值(new Integer())存储在内存堆上的。

基本类型按值传递，封装器按引用传递。

基本类据类型速度快（不涉及到对象的构造和回收），但不是对象，不能调用对象的方法。

> 不同内存区域的功能和特点：<br>
栈区：存放局部变量（变量名，对象的引用等）特点：内存随着函数的调用而开辟，随着函数调用结束而释放。
堆区：存放对象（也就是new出来的东西）特点：可以跨函数使用，每个对象有自己对应的存储空间。<br>
静态域：存放在对象中用static定义的静态成员。<br>
常量池：存放常量。（常量池指的是在编译期被确定，并被保存在已编译的.class文件中的一些数据）

[Java中String类的内存分配](https://jingyan.baidu.com/article/8275fc869a070346a03cf6f4.html)

> Java中，所有基本数据类型的实现类都按照String类的方式重写了equals方法，这些类都符合”==比较对象，equals比较值“这一结论。
如果一个类是你自己定义的，那么如果你不重写equals方法，它还是默认比较对象。（直接调用Object类中的方法）。

[按值传递与按引用传递](http://blog.csdn.net/zzp_403184692/article/details/8184751)


* ##### 自动装箱机制
自动装箱：基本类型用它们对应的封装器包装起来，使它们具有对象的特质，可以调用方法。
```
Integer a = 1;//装箱,底层实现：Integer a = Integer.valueOf(1);
int b = a; //拆箱,底层实现：int b = a.intValue();
```


### 6. Android Activity的基本使用

### 7. Android BroadcastReceiver的基本使用

### 8. 常见布局的使用













上面自己撰写博客中涉及到的Java知识，分别提供demo
三个activity，page 1, page 2, page3
page 1包含两个button 第一个使用显式intent点击跳转到
page 2 第二个使用隐式intent点击跳转到 page 3
page 2 包含一个button，点击发送一个广播
定义一个广播，响应page 2发出的广播，弹出一个toast
page 3，根布局用ScrollView, 其子布局为vertical LinearLayout，内部再添加3个子布局，分别为LinearLayout/RelativeLayout/Framelayout展示3块内容，各内容中用到ImageView, TextView
