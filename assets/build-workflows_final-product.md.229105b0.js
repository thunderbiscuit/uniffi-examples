import{_ as e,o as t,c as i,V as o}from"./chunks/framework.2af28b0a.js";const b=JSON.parse('{"title":"Building ready-to-use libraries","description":"","frontmatter":{},"headers":[],"relativePath":"build-workflows/final-product.md","filePath":"build-workflows/final-product.md"}'),a={name:"build-workflows/final-product.md"},r=o('<h1 id="building-ready-to-use-libraries" tabindex="-1">Building ready-to-use libraries <a class="header-anchor" href="#building-ready-to-use-libraries" aria-label="Permalink to &quot;Building ready-to-use libraries&quot;">​</a></h1><p><strong>The uniffi tool will help you produce two important artifacts:</strong></p><ol><li>The native binaries that are platform-specific and will internally be called by your Kotlin/Swift application.</li><li>The &quot;binding&quot; code that calls into this native library (this defines the public API exposed to a Kotlin dev, for example).</li></ol><br><p><strong>The uniffi library does not help you with the following:</strong></p><ol><li>Bundling these artifacts together so as to ship a working library that will be usable on all platforms you target.</li><li>Publishing these libraries to public repositories so that other developers can use them.</li></ol><p>The pages in this section are meant to provide mental models and help you with these two tasks. They also include information on specific approaches that the Bitcoin Development Kit has chosen to accomplish these tasks, but keep in mind that they are what worked for us but may not be the best approach for your project.</p>',7),l=[r];function s(n,h,d,c,p,u){return t(),i("div",null,l)}const _=e(a,[["render",s]]);export{b as __pageData,_ as default};