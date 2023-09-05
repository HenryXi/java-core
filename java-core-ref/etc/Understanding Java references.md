# Understanding Java references
There are four different types of references in Java. 

|Reference type|code|feature|
|:--- |:--- |:---|
|Strong Reference|`Bar bar = new Bar()` |GC roots => strong references|
|Soft Reference|`SoftReference<Bar> bar;` |JVM memory is not enough => free this part references|
|Weak Reference|`WeakReference<Bar> bar;` |When GC occur => free this part references|
|Phantom Reference|`PhantomReference<Bar> bar;` |Can't get object by this references. Just get notice when recycle this references|

EOF
