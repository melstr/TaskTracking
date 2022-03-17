package ru.mels.tasktracking.repository.impl;

import com.querydsl.jpa.JPQLQuery;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import ru.mels.tasktracking.dto.filter.TaskFilterDto;
import ru.mels.tasktracking.entity.Task;
import ru.mels.tasktracking.repository.TaskCustomRepository;


import java.util.List;

import static ru.mels.tasktracking.entity.QProject.project;
import static ru.mels.tasktracking.entity.QRelease.release;
import static ru.mels.tasktracking.entity.QTask.task;
import static ru.mels.tasktracking.entity.QTaskBoard.taskBoard;


/**
 * @author Meleshkin Alexandr
 * @since 20.03.2022
 */

@Repository
public class TaskCustomRepositoryImpl extends QuerydslRepositorySupport implements TaskCustomRepository {
    public TaskCustomRepositoryImpl() {
        super(Task.class);
    }
    @Override
    public List<Task> findByFilter(TaskFilterDto taskFilterDto) {
        JPQLQuery<Task> query = from(task)
                .innerJoin(task.release, release)
                .innerJoin(release.taskBoard, taskBoard)
                .innerJoin(taskBoard.project, project);


        if(taskFilterDto.getStatus() != null){
            query.where(task.status.eq(taskFilterDto.getStatus()));
        }
        if(taskFilterDto.getAssigneeId() != null){
            query.where(task.assignee.id.eq(taskFilterDto.getAssigneeId()));
        }
        if(taskFilterDto.getReporterId() != null){
            query.where(task.reporter.id.eq(taskFilterDto.getReporterId()));
        }
        if(taskFilterDto.getReleaseId() != null){
            query.where(release.id.eq(taskFilterDto.getReleaseId()));
        }
        if(taskFilterDto.getProjectID() != null){
            query.where(project.id.eq(taskFilterDto.getProjectID()));
        }
        if(taskFilterDto.getTaskBoardID() != null){
            query.where(taskBoard.id.eq(taskFilterDto.getTaskBoardID()));
        }
        if(taskFilterDto.getTitle() != null){
            query.where(task.title.likeIgnoreCase(taskFilterDto.getTitle()));
        }
        if(taskFilterDto.getDescription() != null) {
            query.where(task.description.likeIgnoreCase(taskFilterDto.getDescription()));
        }
        return query.fetch();
    }
}

