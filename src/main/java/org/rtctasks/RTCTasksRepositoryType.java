package org.rtctasks;

import com.intellij.openapi.project.Project;
import com.intellij.tasks.TaskRepository;
import com.intellij.tasks.config.TaskRepositoryEditor;
import com.intellij.tasks.TaskRepositoryType;
import com.intellij.util.Consumer;
import icons.TasksIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by exm1110B.
 * Date: 17/07/2015, 14:53
 */
public class RTCTasksRepositoryType extends TaskRepositoryType<RTCTasksRepository>  {
    public static final String NAME="RTCTasks";
    private static final Icon RTC_ICON = new ImageIcon(RTCTasksRepositoryType.class.getClassLoader().getResource("org/rtctasks/RTC_48.png"),"Icon");// new ImageIcon(RTCTasksRepositoryType.class.getClassLoader().getResource("org/rtctasks/RTC_48.png"), "RTCIcon");
    public static final Icon BUG= TasksIcons.Bug;// new ImageIcon(RTCTasksRepositoryType.class.getClassLoader().getResource("org/rtctasks/Misc-Bug-icon.png"),"Bug");
    public static final Icon FEATURE= new ImageIcon(RTCTasksRepositoryType.class.getClassLoader().getResource("org/rtctasks/star16.png"), "Task");// new ImageIcon(RTCTasksRepositoryType.class.getClassLoader().getResource("org/rtctasks/feature-icon-3.jpg"),"Feature");

    @NotNull
    @Override
    public String getName() {
        return NAME;
    }

    @NotNull
    @Override
    public Icon getIcon() {
        final Icon icon = RTC_ICON;
        return icon;
    }

    @Override
    public @NotNull TaskRepositoryEditor createEditor(RTCTasksRepository rtcTasksRepository, Project project, Consumer<? super RTCTasksRepository> consumer) {
        return new RTCTasksRepositoryEditor(project, rtcTasksRepository, consumer);
    }

    @NotNull
    @Override
    public TaskRepository createRepository() {
        return new RTCTasksRepository(this);
    }

    @Override
    public Class<RTCTasksRepository> getRepositoryClass() {
        return RTCTasksRepository.class;
    }

}
