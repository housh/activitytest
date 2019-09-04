

This demo project is for experiments to find how Activity and Fragment works.
Including cases with different launch modes and nested fragments.

With it you can:
- Watch the lifecycle in logs.
- Open `Do not keep activities` in developer options and see what's the differences.
- Modify to test crash cases.

因自己做了些改动，测试想法，故改版了下，放上去
发现：
- onSaveInstanceState 会自动保存系统控件的状态，但是该控件需要设置Id，比方edittext填写了一些文本，使用设置->不保留活动，按下home键，再返回页面
则该信息还在；如果不设置Id，则不会保存。

- 如果activity中有些变量，页面重建，这些变量不会恢复，有些重要状态，则需要加入存储。

- 如果类似:oncreate中有其他地方传过来的值，那么页面如1一样的操作步骤，这个值仍然可以取到，但是需要做好关联的初始化.
  

## Related Posts,原作者链接:
[Android Do not keep activities选项分析](http://www.cnblogs.com/mengdd/p/4528417.html)

[Android Activity launchMode研究](http://www.cnblogs.com/mengdd/p/4531064.html)

[Android Fragment使用(三) Activity, Fragment, WebView的状态保存和恢复](http://www.cnblogs.com/mengdd/p/5582244.html)


