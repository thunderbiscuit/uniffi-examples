import{_ as s,o as n,c as a,V as p}from"./chunks/framework.2af28b0a.js";const D=JSON.parse('{"title":"Enums","description":"","frontmatter":{},"headers":[],"relativePath":"examples/enums.md","filePath":"examples/enums.md"}'),l={name:"examples/enums.md"},e=p(`<h1 id="enums" tabindex="-1">Enums <a class="header-anchor" href="#enums" aria-label="Permalink to &quot;Enums&quot;">​</a></h1><p>Uniffi can expose Rust enums.</p><p>Suppose a Rust enum is defined as such:</p><div class="language-rust"><button title="Copy Code" class="copy"></button><span class="lang">rust</span><pre class="shiki material-theme-palenight"><code><span class="line"><span style="color:#F78C6C;">pub</span><span style="color:#A6ACCD;"> </span><span style="color:#C792EA;">enum</span><span style="color:#A6ACCD;"> </span><span style="color:#FFCB6B;">Month</span><span style="color:#A6ACCD;"> </span><span style="color:#89DDFF;">{</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">January</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">February</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">March</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">April</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">May</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">June</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">July</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">August</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">September</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">October</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">November</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#A6ACCD;">    </span><span style="color:#FFCB6B;">December</span><span style="color:#89DDFF;">,</span></span>
<span class="line"><span style="color:#89DDFF;">}</span></span></code></pre></div><p>We expose it in the UDL language using the <code>enum</code> keyword like so:</p><div class="language-uniffi-udl"><button title="Copy Code" class="copy"></button><span class="lang">uniffi-udl</span><pre class="shiki material-theme-palenight"><code><span class="line"><span style="color:#A6ACCD;">namespace calendar {};</span></span>
<span class="line"><span style="color:#A6ACCD;"></span></span>
<span class="line"><span style="color:#A6ACCD;">enum Month {</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;January&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;February&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;March&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;April&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;May&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;June&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;July&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;August&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;September&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;October&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;November&quot;,</span></span>
<span class="line"><span style="color:#A6ACCD;">  &quot;December&quot;</span></span>
<span class="line"><span style="color:#A6ACCD;">};</span></span></code></pre></div>`,6),o=[e];function t(c,r,C,u,i,y){return n(),a("div",null,o)}const F=s(l,[["render",t]]);export{D as __pageData,F as default};
