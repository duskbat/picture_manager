USE pm;
DROP TABLE IF EXISTS rating;
CREATE TABLE rating(
ratingId bigint NOT NULL AUTO_INCREMENT COMMENT '评分Id',
userId bigint NOT NULL COMMENT '用户Id',
pictureId bigint NOT NULL COMMENT '图片Id',
rating tinyint NOT NULL COMMENT '评分，1-5',
createTime timestamp COMMENT '创建时间',
PRIMARY KEY (ratingId),
CONSTRAINT fk_picture_Id FOREIGN KEY(pictureId) REFERENCES file_up(id),
CONSTRAINT fk_user_id FOREIGN KEY(userId) REFERENCES user(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评分表';

