package jdbc.dao;

import java.util.List;

import jdbc.entity.Exam;

public interface ExamDao {

	public int add(Exam exam);

	public int update(Exam exam);

	public int delete(int id);

	public Exam findById(int id);

	public List<Exam> findByType(int exam_type);

}