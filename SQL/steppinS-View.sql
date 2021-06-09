CREATE VIEW VW_SNIPPET as
    SELECT dbo.POST.POST_ID,
           dbo.AUTHOR.AUTHOR_ID,
           dbo.AUTHOR.AUTHOR_NAME,
           dbo.POST.POST_TITLE,
           dbo.POST.POST_TIMESTAMP,
           dbo.POST.POST_CODE,
           STRING_AGG(keyword.keyword_id, ', ') as keywordIDs,
           STRING_AGG(keyword.keyword_name, ', ') as Tags,
           STRING_AGG(keyword.keyword_color, ', ') as colors
    FROM dbo.POST
            INNER JOIN dbo.POST_KEYWORD ON dbo.POST.POST_ID = dbo.POST_KEYWORD.POST_ID
            INNER JOIN dbo.KEYWORD ON dbo.POST_KEYWORD.KEYWORD_ID = dbo.KEYWORD.KEYWORD_ID
            INNER JOIN dbo.AUTHOR ON dbo.POST.AUTHOR_ID = dbo.AUTHOR.AUTHOR_ID
            group by post.post_id,
                     author.AUTHOR_NAME,
                     post.post_title,
                     POST.POST_CODE,
                     POST.POST_DESCRIPTION,
                     POST.POST_OUTPUT,
                     POST.POST_SOURCE,
                     POST.POST_TIMESTAMP,
                     AUTHOR.AUTHOR_ID
