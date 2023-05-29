use clock_ffi::Clock;

uniffi::include_scaffolding!("calendar");

struct Calendar {
    id: i32,
    clock: Clock,
}

impl Calendar {
    fn new(id: i32, clock: Clock) -> Self {
        Calendar {
            id,
            clock,
        }
    }

    fn get_info(&self) -> String {
        format!("Your calendar has id {} and a clock that is {:?}", self.id, self.clock.clock_type)
    }

    fn add(&self, a: i32, b: i32) -> i32 {
        a + b
    }
}
