function deleteTopic(element) {
    var topicName = element.getAttribute("data-topicname");
    if (confirm("Are you sure to delete Kafka topic '" + topicName + "'?")) {
        window.location.href = "/delete-topic?topicName=" + encodeURIComponent(topicName);
    }
}
