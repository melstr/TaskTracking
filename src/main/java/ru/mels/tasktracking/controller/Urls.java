package ru.mels.tasktracking.controller;

public interface Urls {
    String ROOT = "/api";

    interface Employee {
        String NAME = "employees";
        String FULL = ROOT + "/" + NAME;

        interface Id {
            String NAME = "employeeId";
            String FULL = Employee.FULL + "/{" + NAME + "}";
        }
    }
    interface Project {
        String NAME = "projects";
        String FULL = ROOT + "/" + NAME;

        interface Id {
            String NAME = "projectId";
            String FULL = Project.FULL + "/{" + NAME + "}";

            interface Status {
                String NAME = "status";
                String FULL = Id.FULL + "/" + NAME;
            }

            interface Task {
                String NAME = "tasks/undone";
                String FULL = Id.FULL + "/" + NAME;
            }
        }
    }
    interface Release {
        String NAME = "releases";
        String FULL = ROOT + "/" + NAME;

        interface Id {
            String NAME = "releaseId";
            String FULL = Release.FULL + "/{" + NAME + "}";

            interface Task {
                String NAME = "tasks/undone";
                String FULL = Release.Id.FULL + "/" + NAME;
            }
        }
    }
    interface TaskBoard {
        String NAME = "taskBoards";
        String FULL = ROOT + "/" + NAME;

        interface Id {
            String NAME = "taskBoardId";
            String FULL = TaskBoard.FULL + "/{" + NAME + "}";
        }
    }

    interface Task {
        String NAME = "tasks";
        String FULL = ROOT + "/" + NAME;
        String FILTER = FULL + "/" + "filter";
        interface Id {
            String NAME = "taskId";
            String FULL = Task.FULL + "/{" + NAME + "}";

            interface Status {
                String NAME = "status";
                String FULL = Task.Id.FULL + "/" + NAME;
            }
        }
    }

}
