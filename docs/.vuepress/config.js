import { defaultTheme, defineUserConfig } from 'vuepress'

export default defineUserConfig({
    lang: "en-US",
    title: "Uniffi Examples",
    description: "Just playing around",
    base: "/uniffi-examples/",
    theme: defaultTheme(
        {
            sidebarDepth: 0,
            contributors: false,
            lastUpdated: false,
            sidebar: [
                {
                    text: "Getting Started",
                    link: "/getting-started/",
                    children: [
                        "/getting-started/introduction.md",
                        "/getting-started/languages.md",
                    ],
                },

                {
                    text: "Examples",
                    link: "/examples/",
                    children: [
                        "/examples/functions.md",
                        "/examples/structs.md",
                        "/examples/enums.md",
                        "/examples/objects.md",
                    ],
                },
            ]
        }
    )
})
