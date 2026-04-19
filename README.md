# krkrz_dev_multi_platform_fork
[Very WIP and NOT RECOMMENDED] My krkrz dev_multi_platform branch fork for Android

## References  
* https://github.com/krkrz/krkrz/tree/3d89b0f203ceca840f62b2e28ad034dea6df41fa
* https://github.com/krkrz/krkrz/tree/dev_multi_platform  

## weibo record
```
另外Kirikiri Z官方仓库有个分支dev_multi_platform是做android版的，
看样子像是可编译的，不过应该还没稳定 ​​​

github上有位仁兄说Kirikiroid2可能永远都不会开源：网页链接。
https://github.com/zeas2/Kirikiroid2/issues/108
我是这么认为的，虽然我的想法可能跟Kirikiroid2的原作者初衷相悖，
但我认为事实上Kirikiroid2的源代码已经跟krkrz的代码库有很大的出入
（我至今都不知道它是从哪个位置分支出来的，可能是一个被删除了的分支，
也许是一个很重要的分支被krkrz有意隐藏了）。所以Kirikiroid2开不开源起初可能会触及原作者的利益。
不过最近几年这个问题其实已经不存在了，原因是krkrz的作者们在不断推动android化的进程，
dev_multi_platform的分支就逐渐开始支持安卓版的编译——虽然我是没试过编译。
至于网上关于kirikiri安卓版的项目，大部分都和dev_multi_platform分支有间接联系，
只不过被单独抽出来移植到别的平台上。有鉴于此，其实现在Kirikiroid2是无所谓开源的，
而关键在于如何编译krkrz的dev_multi_platform分支

这几天研究krkrz（吉里吉里Z，kirikiriz）的dev_multi_platform分支（Android版），
但没研究出来。不过了解到这些知识：（1）可以用Debug.message输出调试信息
（2）可以用Window类的update（搜索update();）刷新屏幕（可能Layer类的update()也可以），
对应C++的代码是TVPPostWindowUpdate异步发送消息刷新窗口
（3）实际上kirikiroid2的画面刷新很简单，就是放到纹理上，具体的位置是UpdateDrawBuffer

krkrz的Android分支dev_multi_platform研究。上次说的没有输出的问题，
我怀疑是TVPPostWindowUpdate没有调用，不过今天测试过好像调用了也没用，
另外我发现它用了NullDrawDevice实现，难道是因为这个原因导致无法输出图像吗？
我打算有时间把krkrsdl2的代码合并进来（我只编译过Linux版，未试过用ndk编译），
或者编译Windows版（这个用处不大），看能不能找到无图像输出的解决方法——可能要搁置很久，
我现在不打算很快解决

krkrz的Android分支dev_multi_platform研究。现在我可以用NDK25和CDT编译运行krkrsdl2的源代码
（原版是用cmake不是用ndk），比较汗流浃背的是，只能用较新的NDK不能用旧的NDK；
而且如果NDK的安卓API目标在23或以上，SDL2会运行期报错提示undefined symbol: stderr，
所以只能修改Application.mk，把APP_PLATFORM :=改成android-21（22可能也可以），
但不能改成23或以上。这俩问题以后想办法解决

我打算把krkrz的dev_multi_platform分支安卓代码和krkrsdl2的安卓代码合并到一起，
需要研究很久，目前的进度是可以用c++_static编译两者（用NDK的clang代替gcc），
并且我尽量想办法缩小两者代码的差距。在我的感觉上，krkrz的代码写得很有问题——不是说写得不好，
而是对GCC和Clang的语法支持非常不好（因为它主要支持VS），另外，
我觉得krkrz的作者似乎也提交代码给krkrsdl2（当然也有可能是我看错了），
如果从实际效果来看dev_multi_platform的代码很可能是打算用krkrsdl2取代的，
甚至可能就是krkrz作者想这样做，当然这只是我的猜测

krkrz android研究。我好像可以勉强跑起来了，方法是换成另一个KAG才行：
krkrz/KAGSigma（因为只有这个KAG才支持drawTexture）。
krkrz的dev_multi_platform分支（支持drawTexture操作）
似乎只能用这个KAG，用其他KAG可以运行但不会有显示输出。
我还需要研究，因为显示是反了，不知道为什么 ​​​

2025/8/12
krkrz android研究。运行效果如下，暂时搁置等以后再看。我只能说很难，
只能勉强跑起来并且显示正确，但比较卡顿（我猜测作者弃了，也可能有新的但没继续开源）。
我运行起来的办法是，krkrz/KAGSigma和krkrz/krkrz/tree/dev_multi_platform
都取相同时间的版本，例如2017年8月1日附近的版本——意味着dev_multi_platform不能用最新版，
只能回退到2017年8月版才能避免出现显示图像翻转的问题

我可以用vs2022编译运行krkrz主分支和dev_multi_platform分支
（其实就是OpenGL版，或者OpenGLES版），后者需要libANGLE（64位的libEGL.dll和libGLESv2.dll复制
到Plugin64目录下）才能运行，我试过用32位的不行，但我又没办法编译出来（编译失败），
所以只能从别的游戏里面复制一份过来用。我之前说过，为了对齐KAGSigma的版本，
所以还需要rollback krkrz的版本，如果不rollback的话看到的图像是上下倒转的。
暂时只能研究到这个程度，实际没有多大意义，因为KAGSigma和KAG3似乎有很大区别，
没办法顺滑迁移。不过PC版的性能可能要好于安卓版，我之前编译成安卓版会比较卡

2026/4/11
之前的说法不对，准确说我是有一个krkrz_dev_multi_platform的代码需要fork出来改
（其实几乎没改过，只是回滚到官方的一个可以运行的版本），
还有一个krkrsdl2的修改版也可以fork出来，这个我修改的版本支持把xp3解包出来
直接放在assets目录下运行（默认好像必须封装成xp3放在assets目录才行）。
我可能今天或者明天把这两份代码放到gh上，用于以后的研究
```

# Original README.md

# 吉里吉里Z

吉里吉里Zは吉里吉里2フォークプロジェクトです。  

2016/08/18  
リポジトリの分割は一通り完了。  
未追加のプラグインは各 Author が追加予定。
今回 external 内の外部ライブラリをサブモジュール化。  
external の各フォルダが空の場合は、サブモジュールのアップデートを。  
今後、 Android 版開発に伴い、ディレクトリ構成が変更される可能性があります。

2016/08/09  
プラグイン等全て一つのリポジトリに入れていたものを削除し、このリポジトリには本体のソースコードのみ入れるようになりました。  
旧ディレクトリ構成は <https://github.com/krkrz/krkrz/tree/last_hodgepodge_repository> ブランチを参照してください。

従来の構成に近い全てを含んだリポジトリは、<https://github.com/krkrz/krkrz_dev> になりました。  
各プラグイン等をサブモジュールとして参照し、独立した形で管理するようになっています。
