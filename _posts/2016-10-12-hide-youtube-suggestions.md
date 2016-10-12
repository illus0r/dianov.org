---
layout: post
published: true
title: Убираем с ютуба рекомендованные ролики
---
![hide-youtube-suggestions.jpg]({{site.baseurl}}/media/hide-youtube-suggestions.jpg)

Я постоянно отвлекаюсь. Бывает, надо по рабочим делам видео посмотреть. А коварный ютуб потом показывает ещё десяток с интересными картинками и названиями. Нажимаю автоматически, даже стыдно.

Наконец додумался заблокировать это дело адблоком. В его конфиг надо добавить две строчки:
```
www.youtube.com##DIV[id="watch7-sidebar-contents"][class="watch-sidebar-gutter   yt-card yt-card-has-padding    yt-uix-expander yt-uix-expander-collapsed"]
www.youtube.com##DIV[class="ytp-endscreen-content"]
```

И красота!