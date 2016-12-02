---
layout: post
published: true
title: Automated editing of multiple files with vim
---
Somethmes you need to process a heap of files, selecting them by mask or by list. It's not common deal so I usually forget a sophisticated `argdo` syntax and do it manually.

But it turned out to be easy! I use **mvim**, but it will work to vim and vi as well.

Firstly, we open a bunch of files:

```
mvim filename-wildcard-1.txt filename-wildcard-2.txt filename-wildcard-3.txt
```

Or use a wildcard:

```
mvim filename-wildcard-*.txt
```

You will see the first file of the bunch.

1. `q` `q` `q` to empty `q` register. If you won't the previous macro from `q` register will run on step 5.
2. `q` `q` to start recording the macro.
3. Do something to file. For example, remove first line with `d` `d`.
4. Hummer out `:w | n` to write the file and to move to the next one.
5. Hit `@q` to run current macro recursively. There's a trick! On step 1. we've cleared the q register and nothing will happen. But after 6 step macro will be written into `q` register and run in this place on the next run.
6. `q` to stop writing macro.
7. `@q` to run the macro. It will run untill `@q` command and then run itself.

After script bumps into the last file, exception will appear. Done!