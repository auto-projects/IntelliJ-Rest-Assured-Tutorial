package test.model;

public class IssueFields {
    // Nested Object with GSON:

    private Fields fields;

    public IssueFields(Fields fields) {
        this.fields = fields;
    }

    public Fields getFields() {
        return fields;
    }

    public static class Fields {
        private String summary;
        private Project project; // Trong 'project'  có 'key'
        private IssueType issuetype; // Trong 'issuetype' có 'id'

        public Fields(String summary, Project project, IssueType issuetype) {
            this.summary = summary;
            this.project = project;
            this.issuetype = issuetype;
        }

        public String getSummary() {
            return summary;
        }

        public Project getProject() {
            return project;
        }

        public IssueType getIssuetype() {
            return issuetype;
        }

        public static class Project {
            private String key;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }

        public static class IssueType {
            private String id;

            public IssueType(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }
        }
    }
}
