package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ToDoModel;

@Repository
public class ToDoRepoImpl implements ToDoRepo {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String createToDo(String name) {
		jdbcTemplate.execute("INSERT INTO TODO VALUES(NULL,'" + name + "','TODO')");
		return "Todo created!";
	}

	@Override
	public List<ToDoModel> getToDos() {
		List<ToDoModel> todos = jdbcTemplate.query("SELECT * FROM TODO", new AllTodoS());
		return todos;
	}

	@Override
	public ToDoModel getToDo(String todoId) {
		ToDoModel todo = jdbcTemplate.query("SELECT * FROM TODO WHERE id = " + todoId,
				new ResultSetExtractor<ToDoModel>() {

					@Override
					public ToDoModel extractData(ResultSet rs) throws SQLException, DataAccessException {
						if (!rs.next()) {
							return null;
						}

						ToDoModel todo = new ToDoModel();
						todo.setId(rs.getLong("id"));
						todo.setName(rs.getString("name"));
						todo.setStatus(rs.getString("status"));

						return todo;
					}

				});

		return todo;
	}

	@Override
	public String deleteToDo(String todoId) {
		jdbcTemplate.execute("DELETE FROM TODO WHERE id = '" + todoId + "'");
		return "Deleted!";
	}

	@Override
	public String changesStatus(String todoId, String status) {
		jdbcTemplate.execute("UPDATE TODO SET status = '" + status + "' WHERE id = '" + todoId + "'");
		return "Status Updated!";
	}

	private class AllTodoS implements ResultSetExtractor<List<ToDoModel>> {

		@Override
		public List<ToDoModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<ToDoModel> todos = new ArrayList<>();

			while (rs.next()) {
				ToDoModel todo = new ToDoModel();
				todo.setId(rs.getLong("id"));
				todo.setName(rs.getString("name"));
				todo.setStatus(rs.getString("status"));

				todos.add(todo);
			}

			return todos;
		}

	}
}
