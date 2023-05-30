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
        ]
      },
    ],
  },
})
