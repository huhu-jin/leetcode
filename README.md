
配置 IDE leetcode插件

- TemplateFilePath 项目路径
```
/Users/jinzh3/workspace/jin/leetcode/src/main/java/com/jin/learn
```

- CodeFileName 类名的命名规范

```
$!velocityTool.camelCaseName(${question.titleSlug})
```

- CodeTemplate 类模板的具体内容

```
//  [${question.frontendQuestionId}]${question.title}

${question.content}

package com.jin.learn.leetcode.editor.cn

public class $!velocityTool.camelCaseName(${question.titleSlug}){
  
  
  ${question.code}
  
}
```
最后勾上
 - [x] Custom Template
