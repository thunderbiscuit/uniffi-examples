uniffi::include_scaffolding!("calendar");

struct Calendar {
    id: i32
}

impl Calendar {
    fn new(id: i32) -> Self {
        Calendar { id }
    }

    fn get_info(&self) -> String {
        format!("Your calendar has id {}", self.id)
    }

    fn add(&self, a: i32, b: i32) -> i32 {
        a + b
    }

    fn divide(&self, a: i32, b: i32) -> Result<i32, CalendarError> {
        if b == 0 {
            Err(CalendarError::DivisionBy0)
        } else {
            let answer: i32 = a / b;
            Ok(answer)
        }
    }
}

#[derive(Debug)]
pub enum CalendarError {
    DivisionBy0,
}

impl std::fmt::Display for CalendarError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "{:?}", self)
    }
}
