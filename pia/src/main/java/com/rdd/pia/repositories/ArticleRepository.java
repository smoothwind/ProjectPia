package com.rdd.pia.repositories;

import com.rdd.pia.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author smoothwind
 */
public interface ArticleRepository extends JpaRepository<Article,Long> {
  //////////创建文章 ////////////////////////

    /** 保存文章
     * @param s 文章
     * @param <S> 文章类
     * @return 文章实体
     */
    @Override
    <S extends Article> S save(S s);


    ///////// 文章查找 /////////////////
    /** 获取作者的文章列表
     * @param authorId 作者ID
     * @return 文章列表
     */
    @Query
    List<Article> findAllByAuthorId(int authorId);


    /** 获取某篇文章
     * @param idArticle 文章ID
     * @return 文章
     */
    @Query
    Article findByIdArticle(int idArticle);



    ///////////////// 文章删除 ///////////////////////

    /** 物理删除草稿：空文章
     * @param articleId 文章ID
     * @return 是否成功
     */
    @Query
    boolean deleteArticleByIdArticleEquals(int articleId);


    // TODO: boolean logicDeleteArticleByArticleId(int articleId);

    /////////////// 文章更新 ///////////


    /** 更新文章内容及状态
     * @param articleId 文章ID
     * @param body 文章主题
     * @param status 状态
     * @param updateTime 更新时间
     * @return 是否成功
     */
    @Query(value = " update app.article t set t.article_body = ?2, t.status = ?3, t.update_time = ?4 where t.idarticle = ?1", nativeQuery = true)
    boolean updateArticleByArticleId(int articleId, String body, int status, Date updateTime);
}
