# GraphQL POC
> minor POC to run wild with GraphQL

Current test:

```text
query {
    recentPosts(count: 2, offset: 0) {
        id
        title
    		category
        author {
          posts {
            id
            category
          }
        }
    }
}
```

## Meta

Alex Rocha - [about.me](http://about.me/alex.rochas) -