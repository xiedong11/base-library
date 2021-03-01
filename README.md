### 项目基础依赖框架

#### 框架依赖说明

#### 项目快速引入
**Project添加**
```java
repositories {
        google()
        jcenter()
        maven { url "https://raw.github.com/bmob/bmob-android-sdk/master" }
        maven { url 'https://jitpack.io' }
    }
```
**Module下添加**
```java
implementation 'com.github.xiedong11:base-library:1.1'
```
###### 页面快速搭建基础类
- BaseActivity
- BaseFragment

###### 长列表快速搭建基础依赖，抽象adapter，可定制item数据绑定
- BaseAdapter
- BaseViewHolder

##### 内置三方依赖版本说明
- 云数据库 `Bmob 3.6.8`
- 图片加载管理的 `glide 3.7.0`
- 消息总线 `eventbus 3.0.0`

##### com.github.xiedong11:base-library:1.5
- 引入retrofit快速配置工具类



