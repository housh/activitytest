

This demo project is for experiments to find how Activity and Fragment works.
Including cases with different launch modes and nested fragments.

With it you can:
- Watch the lifecycle in logs.
- Open `Do not keep activities` in developer options and see what's the differences.
- Modify to test crash cases.

因自己做了些改动，测试想法，故改版了下，放上去
发现：
- onSaveInstanceState并不会自动保存一些控件的状态，比方edittext填写了一些文本，使用设置->不保留活动，按下home键，再返回页面
则该信息丢失了，如果说遇到这样的场景，信息需要提示保存或者说需要存储在onSaveInstanceState。

- 如果类似，oncreate中有其他地方传过来的值，那么页面如1一样的操作步骤，这个值仍然可以取到，需要做好关联的初始化.
  

## Related Posts,原作者链接:
[Android Do not keep activities选项分析](http://www.cnblogs.com/mengdd/p/4528417.html)

[Android Activity launchMode研究](http://www.cnblogs.com/mengdd/p/4531064.html)

[Android Fragment使用(三) Activity, Fragment, WebView的状态保存和恢复](http://www.cnblogs.com/mengdd/p/5582244.html)


