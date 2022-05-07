
配置 IDE leetcode插件

- TemplateFilePath 项目路径
```
/home/jin/workspace/home/java/leetcode/src/main/java/com/jin/learn/
```

- CodeFileName 类名的命名规范

```
$!velocityTool.camelCaseName(${question.titleSlug})
```

- CodeTemplate 类模板的具体内容

```
//  [${question.frontendQuestionId}]${question.title}

${question.content}

package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class $!velocityTool.camelCaseName(${question.titleSlug}){
  
  
    ${question.code}
    
    @Test
    public void testCase(){
        
    }
  
}
```
最后勾上
 - [x] Custom Template
