USE word_db;
select * from sentences,words
where 
case
when words.word_en=sentences.sentence_wen then sentences.sentence_wid=words.word_id
END
