import { defineConfig } from 'vitepress'

export default defineConfig({
  title: "Uniffi-Examples",
  description: "",
  base: "/uniffi-examples/",
  themeConfig: {
    search: {
      provider: "local"
    },

    sidebar: [
      // Getting Started
      {
        text: "Getting Started",
        collapsed: false,
        items: [
          { text: "Introduction", link: "/getting-started/introduction.md" },
          { text: "Languages", link: "/getting-started/languages.md" },
        ]
      },

      // Examples
      {
        text: "Examples",
        collapsed: false,
        items: [
          { text: "Functions", link: "/examples/functions.md" },
          { text: "Enums", link: "/examples/enums.md" },
          { text: "Structs", link: "/examples/structs.md" },
          { text: "Objects", link: "/examples/objects.md" },
          { text: "Callbacks", link: "/examples/callbacks.md" },
          { text: "Multiple Libraries", link: "/examples/multiple-libraries.md" },
        ]
      },

      // Building and Publishing
      {
        text: "Building and Publishing",
        collapsed: false,
        items: [
          { text: "Building Complete Libraries", link: "/build-workflows/final-product.md" },
          { text: "General Approach", link: "/build-workflows/general.md" },
          { text: "Optimizations", link: "/build-workflows/optimizations.md" },
        ]
      },
    ],
  },
})
