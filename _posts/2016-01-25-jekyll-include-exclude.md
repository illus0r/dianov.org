---
title: Making customer specific site versions
---

UPD: bad approach, don't use it 😶

Jekyll provides great tool to keep separate folders with customer specific data. You can select one of them withing a single line in a config:

```yml
exclude:
  - _cards/
  - _areas/

include:
  - .htaccess
  - client1 
```

note, that is mask, so it matches to all files and folders containing

```
client1,
/client1/,
/client11/,
/_cards/client1/,
client1.md
```

Masks act a bit weiredly: `client*` will match to `client1/`, but `client*/` will not.


Unfortunately jekyll doesn't process collections nested to folders like `/client1/_cards`, it would be the most elegant solution though.
