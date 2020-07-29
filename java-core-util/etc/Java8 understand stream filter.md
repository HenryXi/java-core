# Java8 understand stream filter
I knew a long time ago that there is a method `filter` in `stream`. Every time I use it, I don’t know how it filters internally.
Will he remove the qualified ones or leave the qualified ones? Every time I need to run the code to make sure my logic is correct.

I understand method `filter` like this.

If you do not use `stream` to achieve filtering, the approximate code should look like the following
```
for(Item item:itemCollection){
    if(item meets the conditions){
        do something here
    } 
}
```

The question is what needs to be done after meeting the conditions. This element must not be removed from the collection. 
That would cause loop errors. So the code should generally look like this.
```
Collection c = new Collection()
for(Item item:itemCollection){
    if(item meets the conditions){
        c.add(item)
    } 
}
```
At this point, the logic is very clear. The logic in method `filter` must be that the elements that meet this condition are left 
instead of being removed.


EOF