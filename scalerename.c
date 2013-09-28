#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/stat.h>
#include <unistd.h>

void getdir(char *dirpath)
{
    int len;

    scanf("%s", dirpath);
    len = strlen(dirpath);
    if (*(dirpath+len-1) != '/')
    {
        *(dirpath+len) = '/';
        *(dirpath+len+1) = '\0';
    }
}
void getfilepath(char *dirpath, char **filepath)
{
    DIR *dir;
    struct dirent *dp;
    char *p;

    p = (char *)malloc(100*sizeof(char));
    dir = opendir(dirpath);
    while ((dp = readdir(dir)) != NULL)
    {
        struct stat st;

        sprintf(p, "%s%s", dirpath, dp->d_name);
        // p = memset(p, 0, 100);
        // p = strcat(p, dirpath);
        // p = strcat(p, dp->d_name);

        // sprintf((*filepath)++, "%s", p);
        stat(p, &st);
        if (S_ISREG(st.st_mode))
        {
            sprintf(*filepath++, "%s", p);
            // memcpy((*filepath)++, p, 100);
        }
    }

    free(p);
    p = NULL;

    closedir(dir);
}
void scalerename(char **filepath, char *dirpath)
{
    char *pre = (char *)malloc(100*sizeof(char));
    char *sub = (char *)malloc(100*sizeof(char));
    char *newpath = (char *)malloc(100*sizeof(char));
    int i = 0;

    printf("输入公共前缀：");
    scanf("%s", pre);
    printf("输入公共后缀：");
    scanf("%s", sub);

    while (**(filepath+i))
    {
        sprintf(newpath, "%s%s%02d%s", dirpath, pre, i+1, sub);
        rename(*(filepath+i), newpath);
        i++;
    }

    free(pre);
    free(sub);
    free(newpath);
    pre = sub = newpath = NULL;
}

int main(void)
{
    char *dirpath;
    char **filepath;
    int i = 0;

    dirpath = (char *)malloc(100*sizeof(char));
    filepath = (char **)malloc(100*sizeof(char *));
    for (i = 0; i < 100; ++i)
        *(filepath+i) = (char *)malloc(100*sizeof(char));
    
    getdir(dirpath);
    getfilepath(dirpath, filepath);
    scalerename(filepath, dirpath);
    while (*filepath)
        free(*filepath++);
    free(dirpath);
    return 0;
}
